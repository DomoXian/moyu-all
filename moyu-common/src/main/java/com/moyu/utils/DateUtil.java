package com.moyu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XianGuo
 * Date: 2017-07-23 00:22
 * 日期工具类
 */
public class DateUtil {


    public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD = "yyyy-MM-dd";

    public static String getFormat(Date date, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    public static String getYmdHmsFormat(Date date) {
        return getFormat(date, YMD_HMS);
    }

    public static String getYmdFormat(Date date) {
        return getFormat(date, YMD);
    }

    public static void main(String[] args){
        System.out.println(getYmdHmsFormat(new Date()));
        System.out.println(getYmdFormat(new Date()));
    }
}
