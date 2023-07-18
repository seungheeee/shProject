package com.example.demo.service;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.NcFileDto;
import com.example.demo.dto.ReadNcfileInfoDto;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucar.ma2.ArrayInt;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class NcFileService {

    @Resource
    NcFileDto ncfileDto;

    @Resource
    ReadNcfileInfoDto ncfileInfoDto;

    NetcdfFile ncfile = null;
    public void ncfileOpen() throws Exception{
        File fullPath = new File(ncfileInfoDto.getFullPath());
        if(fullPath.isFile()) {
            ncfile = ncfile.open(ncfileInfoDto.getFullPath());
            ncfileDto = NcFileDto.builder()
                    .netcdfFile(ncfile)
                    .build();
        }else{
            System.out.println("존재하지않는 파일");
            throw new Exception();
        }
        
    }

    public String ncfileInfo() throws Exception{
        ncfile = ncfileDto.getNetcdfFile();
        String ncfileInfo = ncfile.getVariables().toString();
        return ncfileInfo;
    }

    public void getShape() {
        String varName = ncfileInfoDto.getVarName();
        Variable variable = ncfileDto.getNetcdfFile().findVariable(varName);
        HashMap<String, int[]> shapeMap = new HashMap<>();
        shapeMap.put(varName, variable.getShape());

        ncfileDto = NcFileDto.builder()
                .shapeGroup(shapeMap)
                .build();
    }

    public void getData() throws IOException {
        Variable variable = ncfileDto.getNetcdfFile().findVariable(ncfileInfoDto.getVarName());
        ArrayInt.D3 ncData = (ArrayInt.D3) variable.read();
        HashMap<String, Object> data = new HashMap<>();
        data.put(ncfileInfoDto.getVarName(),ncData.get(ncfileInfoDto.getTimeIdx(),ncfileInfoDto.getLatIdx(),ncfileInfoDto.getLonIdx()));
        ncfileDto.setDataArray(data);
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
