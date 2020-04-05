package com.project.manager.common.utils;

public class StringUtils {
    public static void main(String[] args) {
    }

    public static boolean isNotNull(String string) {
        return string != null && string.trim().length() > 0;
    }

    public static boolean isNull(String string) {
        return string == null || string.trim().length() == 0;
    }

}
