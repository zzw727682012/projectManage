package com.project.manager.common.utils;

public class StringUtils {
    public static void main(String[] args) {
        System.out.println(isNotNull(""));
    }

    public static boolean isNotNull(String string) {
        return string != null && string.length() > 0;
    }
}
