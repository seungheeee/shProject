package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import ucar.nc2.NetcdfFile;

import java.util.HashMap;

@Data
@Builder
public class NcFileDto {
    private NetcdfFile netcdfFile;
    private HashMap<String, int[]> shapeGroup;
    private HashMap<String, Object> dataArray;
    //time, lon, lat idx
}
