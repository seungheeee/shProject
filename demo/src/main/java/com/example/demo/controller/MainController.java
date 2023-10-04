package com.example.demo.controller;

import com.example.demo.dto.NcFileDto;
import com.example.demo.dto.NcfileResDto;
import com.example.demo.service.NcFileService;
import com.example.demo.util.PngCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

@RestController
public class MainController {

    //private final NcFileService ncFileService;

    @Autowired
    private NcFileService ncFileService;

    /*
    @GetMapping("/api/hello")
    public String hello() throws Exception {
        List<MemberDto> list = memberService.selectMemberList();
        return "안녕하세요. 리액트와 스프링부트를 Proxy 설정을 통해 연결하고있습니다." + list.get(0);
    }
*/

    @GetMapping("/api/ncfile")
    public ResponseEntity ncfileApi(
            @RequestParam(defaultValue = "1",name = "sTime") int sTime
            , @RequestParam(defaultValue = "unknown",name = "varName") String varName
            , @RequestParam(defaultValue = "5",name = "km") int km
            //, @RequestParam("selectYear") int selectYear
            //, @RequestParam("selectMonth") int selectMonth
    ) throws Exception {
        String fullPath = "";
        System.out.println(km);
        if(km == 1){
            fullPath = "C:\\PROJECT_2022\\mapTest\\DATA\\nc\\DFS_SHRT_GRD_GDPS_NPPM_T1H.202201010000.nc";
            varName = "T1H";
        }else{
            fullPath = "C:\\PROJECT_2022\\mapTest\\DATA\\nc\\DFS_SHRT_GRD_GRB4_PCP.202201162000.nc";
        }


        NcFileDto ncFileDto = ncFileService.getData(fullPath, sTime, varName);
        return ResponseEntity.status(HttpStatus.OK).body(ncFileDto);
    }

    @GetMapping("/api/ncfileImg")
    public ResponseEntity<NcfileResDto> imageApi(
            @RequestParam(defaultValue = "1",name = "sTime") int sTime
            , @RequestParam(defaultValue = "unknown",name = "varName") String varName
            , @RequestParam(defaultValue = "5",name = "km") int km
            //, @RequestParam("selectYear") int selectYear
            //, @RequestParam("selectMonth") int selectMonth
    ) throws Exception {
        String fullPath = "";
        if(km == 1){
            fullPath = "C:\\PROJECT_2022\\mapTest\\DATA\\nc\\DFS_SHRT_GRD_GDPS_NPPM_T1H.202201010000.nc";
            varName = "T1H";
        }else{
            fullPath = "C:\\PROJECT_2022\\mapTest\\DATA\\nc\\DFS_SHRT_GRD_GRB4_PCP.202201162000.nc";
        }

        long startTime = System.nanoTime();

        NcFileDto ncFileDto = ncFileService.getData(fullPath, sTime, varName);

        long secondTime = System.nanoTime();
        double duration = (double) (secondTime - startTime) / 1_000_000;  // Convert to milliseconds
        System.out.println("ncfile read : " + duration + " ms");

        PngCreator pngCreator = new PngCreator();
        File imageFile = ncFileService.getColor(ncFileDto.getDataArray(), ncFileDto.getSmallest(), ncFileDto.getLargest(), km);
        String base64Image = pngCreator.encodeFileToBase64Binary(imageFile);

        // 파일을 Resource로 변환
        InputStreamResource resource = new InputStreamResource(new FileInputStream(imageFile));
        long endTime = System.nanoTime();
        duration = (double) (endTime - secondTime) / 1_000_000;  // Convert to milliseconds
        System.out.println("image create : " + duration + " ms");

        NcfileResDto responseDto = new NcfileResDto();
        responseDto.setData(ncFileDto);
        responseDto.setBase64EncodedImage(base64Image);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/api/updateNcfile")
    public ResponseEntity<String> updateDataValue(@RequestBody Map<String, String> newValue) {
        try {
            System.out.println("newValue size : " + newValue.size());
            for (Map.Entry<String, String> entry : newValue.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
            String filePath = "C:\\PROJECT_2022\\DFS_SHRT_GRD_GRB4_PCP.202201162000.nc";
            String variableName = "unknown";

            ncFileService.updateDataValue(filePath, variableName, newValue);
            return ResponseEntity.ok("Data value updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating data value.");
        }
    }
}
