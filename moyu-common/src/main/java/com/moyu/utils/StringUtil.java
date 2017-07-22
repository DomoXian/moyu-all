package com.moyu.utils;

/**
 * Created by XianGuo
 * Date: 2017-07-23 00:20
 * 字符串工具
 */
public class StringUtil {


    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
