package com.example.demo.controller;

import com.example.demo.dto.NcFileDto;
import com.example.demo.service.NcFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam(defaultValue = "0",name = "sTime") int sTime
            , @RequestParam(defaultValue = "unknown",name = "varName") String varName
            //, @RequestParam("selectYear") int selectYear
            //, @RequestParam("selectMonth") int selectMonth
    ) throws Exception {
        String fullPath = "C:\\PROJECT_2022\\DFS_SHRT_GRD_GRB4_PCP.202201162000.nc";

        //return ncFileService.getData(fullPath, sTime, varName);
        NcFileDto ncFileDto = ncFileService.getData(fullPath, sTime, varName);
        return ResponseEntity.status(HttpStatus.OK).body(ncFileDto);
    }
}
