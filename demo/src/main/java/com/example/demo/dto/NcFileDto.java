package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@Data
public class NcFileDto {
    private double[] dataArray;
    private double smallest;
    private double largest;
    private List<Color> colorArray;
}
