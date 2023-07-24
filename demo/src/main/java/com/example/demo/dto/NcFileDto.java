package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@Component
public class NcFileDto {
    private double[] dataArray;
    private List<String> colorArray;
}
