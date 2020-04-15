package com.Utils;

public class StringUtil {
    /**
     * 判断字符串是否为空"   "返回为ture
     * @param
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;


    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
