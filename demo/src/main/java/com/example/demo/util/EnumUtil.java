package com.example.demo.util;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EnumUtil {
    public static Color[] getAllColors(String enumName) {
        try {
            Class<?> enumClass = Class.forName("com.example.demo.util.ElementRangeEnum$" + enumName);
            Object[] enumValues = enumClass.getEnumConstants();
            Color[] colors = new Color[enumValues.length];

            Method getColorMethod = enumClass.getMethod("getColor");

            for (int i = 0; i < enumValues.length; i++) {
                colors[i] = (Color) getColorMethod.invoke(enumValues[i]);
            }
            return colors;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to retrieve colors.", e);
        }
    }
}
