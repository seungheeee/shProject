package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.NcFileDto;
import com.example.demo.dto.ReadNcfileInfoDto;
import com.example.demo.service.MemberService;
import com.example.demo.service.NcFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucar.nc2.NetcdfFile;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private MemberService memberService;



    @GetMapping("/api/hello")
    public String hello() throws Exception {
        List<MemberDto> list = memberService.selectMemberList();
        return "안녕하세요. 리액트와 스프링부트를 Proxy 설정을 통해 연결하고있습니다." + list.get(0);
    }

    @GetMapping("/api/ncfile")
    public NcFileDto.NcFileDtoBuilder ncfileApi() throws Exception {
        NcFileService ncFileService = new NcFileService();
        String fullPath = "C:\\PROJECT_2023\\lowattr_climate\\src\\main\\webapp\\DATA\\netCDF_file\\000\\era5_000_monthly_0000m_ta_1991_2021.nc";
        ReadNcfileInfoDto readNcfileInfoDto;

        /*
                readNcfileInfoDto.setFullPath(fullPath);
        readNcfileInfoDto.setVarName("TA");
        readNcfileInfoDto.setLatIdx(0);
        readNcfileInfoDto.setLonIdx(0);
        readNcfileInfoDto.setTimeIdx(0);
         */
        ReadNcfileInfoDto.builder()
                .fullPath(fullPath)
                .varName("TA")
                .timeIdx(0)
                .lonIdx(0)
                .latIdx(0)
                .build();

        ncFileService.ncfileOpen();
        ncFileService.getData();

        return NcFileDto.builder();
    }
}
