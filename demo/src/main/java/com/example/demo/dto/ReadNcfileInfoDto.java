package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadNcfileInfoDto {
    private String fullPath;
    private int timeIdx;
    private int latIdx;
    private int lonIdx;
    private String varName;
}
