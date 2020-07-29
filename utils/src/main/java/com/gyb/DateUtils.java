package com.gyb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author gb
 * @Date 2020/7/27 17:21
 * @Version 1.0
 * description:日期转换
 */

public class DateUtils {

    /**
     * create by: gb
     * description: 日期转换成字符串
     * create time: 2020/7/27 17:21
     *
     * @param date    要转换的日期
     * @param pattern 转换成的格式 例如xxx-xxx-xxx等等
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String format = dateFormat.format(date);
        return format;

    }

    /**
     * create by: gb
     * description: 字符串转日期
     * create time: 2020/7/27 17:30
     *
     * @param pattern 格式
     * @param str     字符串日期
     * @return
     */
    public static Date stringStoDate(String str, String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse(str);
        return date;


    }
}