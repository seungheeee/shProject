package com.example.demo.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class PngCreator {
    public String encodeFileToBase64Binary(File file) throws IOException {
        FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fileInputStreamReader.read(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public File writeFile(BufferedImage image){
        File output = new File("createdImage.png");
        try {
            ImageIO.write(image, "png", output);
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
