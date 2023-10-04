package com.example.demo.dto;

import lombok.Data;

@Data
public class NcfileResDto {
    private NcFileDto data;
    private String base64EncodedImage;
}
