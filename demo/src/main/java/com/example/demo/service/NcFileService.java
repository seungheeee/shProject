package com.example.demo.service;

import com.example.demo.dto.NcFileDto;
import com.example.demo.util.PngCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucar.ma2.*;
import ucar.nc2.*;
import ucar.nc2.dataset.NetcdfDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class NcFileService {

    //private NcFileDto ncfileDto;

    //@Autowired
//    public NcFileService(NcFileDto ncFileDto){
//        this.ncfileDto = ncFileDto;
//    }

    public NcFileDto getData(String fullPath, int sTime, String varName) throws Exception {
        NetcdfFile ncfile = ncfileOpen(fullPath);
        Variable variable = ncfile.findVariable(varName);
        int[] shapeArr = getShape(ncfile, varName);

        List<Range> lr = processExtract(sTime, shapeArr);
        Array ncData = variable.read(lr);
        double scaleFactor = 1;
        Attribute attribute = variable.findAttribute("scale_factor");
        if (attribute != null) {
            scaleFactor = attribute.getNumericValue().doubleValue();
        } else {
            System.out.println("scale_factor 존재하지않음");
        }

        float[] intData = (float[]) ncData.copyTo1DJavaArray();
        double[] dataArray = new double[intData.length];

        double smallest = intData[0];
        double largest = intData[0];
        for (int i = 0; i < intData.length; i++) {
            if (intData[i] < smallest) {
                smallest = intData[i];  // Update smallest if current element is smaller
            } else if (intData[i] > largest) {
                largest = intData[i];  // Update largest if current element is larger
            }
            dataArray[i] = climateRound(intData[i] * scaleFactor);
        }
        NcFileDto ncfileDto = new NcFileDto();
        ncfileDto.setDataArray(dataArray);
        ncfileDto.setLargest(largest);
        ncfileDto.setSmallest(smallest);

        //List<Color> colorArray = getColor(dataArray, smallest * scaleFactor, largest * scaleFactor);

        //ncfileDto.setColorArray(colorArray);
        ncfile.close();
        return ncfileDto;
    }

    public double climateRound(double data) {
        data = (data * 10) + 0.5;
        data = Math.floor(data);
        data *= 0.1;
        return Double.parseDouble(String.format("%.1f", data));
    }

    public List<Range> processExtract(int sTime, int[] shapeArr) throws InvalidRangeException, IOException {
        List<Range> rangeList = IntStream.range(0, 3)
                .mapToObj(i -> {
                    try {
                        return i == 0 ? new Range(sTime, sTime, 1) : new Range(0, shapeArr[i] - 1, 1);
                    } catch (InvalidRangeException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

        List<Range> lr = rangeList.stream()
                .limit(3)
                .collect(Collectors.toList());

        return lr;
    }

    public NetcdfFile ncfileOpen(String fullPath) throws Exception{
        File file = new File(fullPath);
        NetcdfFile ncfile = null;
        if(file.isFile()) {
            ncfile = ncfile.open(fullPath);
            String ncfileInfo = ncfileInfo(ncfile);
            System.out.println(ncfileInfo);
            return ncfile;
        }else{
            System.out.println("존재하지않는 파일");
            throw new Exception();
        }
    }

    public String ncfileInfo(NetcdfFile ncfile) throws Exception{
        String ncfileInfo = ncfile.getVariables().toString();
        return ncfileInfo;
    }

    public int[] getShape(NetcdfFile ncfile, String varName) {
        Variable variable = ncfile.findVariable(varName);
        return variable.getShape();
    }

    public File getColor(double[] value, double smallest, double largest, int km) {
        List<Color> colorArray = new ArrayList<>();
        //String[] rgbArr = {"rgb(0,0,248)", "rgb(0,69,255)" , "rgb(0,144,255)", "rgb(0,219,255)" , "rgb(110,255,145)" ,"rgb(235,255,20)" , "rgb(255,184,0)" , "rgb(255,100,0)" , "rgb(255,16,0)" , "rgb(160,0,0)"};
        Color[] rgbArr = {
                new Color(0, 0, 248),
                new Color(0, 69, 255),
                new Color(0, 144, 255),
                new Color(0, 219, 255),
                new Color(110, 255, 145),
                new Color(235, 255, 20),
                new Color(255, 184, 0),
                new Color(255, 100, 0),
                new Color(255, 16, 0),
                new Color(160, 0, 0)
        };
        int size = 1;
        if(km == 1) size = 5;
        int width = 149 * size; // 이미지의 너비
        int height = 253 * size; // 이미지의 높이
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        double interval = (largest - smallest) * 0.1;
        double[] rangeArr = new double[10];

        for(int i = 0; i < 10; i++){
            rangeArr[i] = smallest + (i * interval);
        }

        Color color = null;
        for(int i = 0; i < value.length; i++){
            for(int j = 0; j < rangeArr.length; j++){
                if(j != 9){
                    if(value[i] >= rangeArr[j] && value[i] < rangeArr[j+1]){
                        //colorArray.add(rgbArr[j]);
                        color = rgbArr[j];
                        break;
                    }else if(value[i] < rangeArr[0]){
                        color = rgbArr[0];
                        break;
                    }
                }else if(j == 9){
                    if(value[i] > rangeArr[9]){
                        color = rgbArr[9];
                        break;
                    }
                }
            }
            image.setRGB(i%width, height - 1 - (i/width), color.getRGB());
        }
        //double hue = (1 - value) * 120;
        PngCreator pngCreator = new PngCreator();
        return pngCreator.writeFile(image);
    }

    public void updateDataValue(String filePath, String variableName, Map<String, String> newValue) throws Exception {
        NetcdfFile netcdfFile = null;
        NetcdfFileWriter writer = null;
        int sTime = 0;

        try {
            //netcdfFile = NetcdfFile.open(filePath);
            writer = NetcdfFileWriter.openExisting(filePath);
            Variable var = writer.findVariable(variableName);
            if (var == null) {
                System.out.println("Can't find variable 'TA'");
                return;
            }
            int[] shapeArr = var.getShape();

            List<Range> lr = processExtract(sTime, shapeArr);

            Array taArray = var.read(lr).copy();
            float[] intData = (float[]) taArray.copyTo1DJavaArray();

            // Assuming newValue is a map of {index: value}, where index is the 1D index and value is a string that can be converted to double
            for (Map.Entry<String, String> entry : newValue.entrySet()) {
                int index1D = Integer.parseInt(entry.getKey());
                Float value = Float.parseFloat(entry.getValue());
                taArray.setFloat(index1D, value);
            }

            // Write the updated array back to the file
            writer.write(var, taArray);

            System.out.println("variable updated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (netcdfFile != null) {
                try {
                    netcdfFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

/*
    public void sample(){
        for(timeIdx = sTime; timeIdx < sTime + (12 * selectYear); timeIdx++) {
            if(isSelectedMonth(timeIdx, selectMonth)) {
                processLatLong(data, multiData, yearIdx, dataLen, timeIdx, timeShape, param, nullCnt, latlonIdx);
                calculateAvgData(avgData, yearIdx, data, dataLen, monthLen, nullCnt);
                latlonIdx = 0;
                yearIdx++;
                nullCnt = 0;
            }
        }

// Check if the given month is selected
        private boolean isSelectedMonth(int timeIdx, int selectMonth) {
            return selectMonth == timeIdx % 12;
        }

// Process latitude and longitude data
        private void processLatLong(int[][] data, MultiData multiData, int yearIdx, int[] dataLen, int timeIdx, int[] timeShape, Map<String, String> param, int nullCnt, int latlonIdx) {
            for(int latIdx = 0; latIdx < dataLen[0]; latIdx++) {
                for(int lonIdx = 0; lonIdx < dataLen[1]; lonIdx++) {
                    processCellData(data, multiData, yearIdx, timeIdx, latIdx, lonIdx, timeShape, param, nullCnt, latlonIdx);
                }
            }
        }

// Process individual cell data
        private void processCellData(int[][] data, MultiData multiData, int yearIdx, int timeIdx, int latIdx, int lonIdx, int[] timeShape, Map<String, String> param, int nullCnt, int latlonIdx) {
            if(isDataNull(multiData.get(timeIdx, latIdx, lonIdx))) {
                nullCnt++;
                data[yearIdx][latlonIdx++] = 0;
            } else {
                if(isValidTime(timeIdx, timeShape)) {
                    data[yearIdx][latlonIdx++] = multiData.get(timeIdx, latIdx, lonIdx);
                }
                if(isSeasonal(param) && (timeIdx < timeShape[0] -1)) {
                    processSeasonalData(data, multiData, yearIdx, timeIdx, latIdx, lonIdx, latlonIdx);
                }
            }
        }

// Check if data is null
        private boolean isDataNull(int data) {
            return data == -999;
        }

// Check if time is valid
        private boolean isValidTime(int timeIdx, int[] timeShape) {
            return timeIdx != timeShape[0];
        }

// Check if data is seasonal
        private boolean isSeasonal(Map<String, String> param) {
            return param.get("DETAIL_PERIOD").equals("SEASON");
        }

// Process seasonal data
        private void processSeasonalData(int[][] data, MultiData multiData, int yearIdx, int timeIdx, int latIdx, int lonIdx, int latlonIdx) {
            data[yearIdx][latlonIdx++] = isDataNull(multiData.get(timeIdx + 1, latIdx, lonIdx)) ? 0 : multiData.get(timeIdx + 1, latIdx, lonIdx);
            data[yearIdx][latlonIdx++] = isDataNull(multiData.get(timeIdx + 2, latIdx, lonIdx)) ? 0 : multiData.get(timeIdx + 2, latIdx, lonIdx);
        }

// Calculate average data
        private void calculateAvgData(double[] avgData, int yearIdx, int[][] data, int[] dataLen, int monthLen, int nullCnt) {
            if(nullCnt != dataLen[0] * dataLen[1] * monthLen) {
                avgData[yearIdx] = climateRound((Arrays.stream(data[yearIdx]).sum() / ((dataLen[0] * dataLen[1] * monthLen) - nullCnt) * 0.1));
            } else {
                avgData[yearIdx] = -999;
            }
        }
    }*/
}
