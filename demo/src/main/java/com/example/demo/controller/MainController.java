package com.example.demo.controller;

import com.example.demo.dto.NcFileDto;
import com.example.demo.service.NcFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@RestController
public class MainController {

    private final NcFileService ncFileService;

    @Autowired
    public MainController(NcFileService ncFileService) {
        this.ncFileService = ncFileService;
    }

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


        System.out.println(varName);
        NcFileDto ncFileDto = ncFileService.getData(fullPath, sTime, varName);
        return ResponseEntity.status(HttpStatus.OK).body(ncFileDto);
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
