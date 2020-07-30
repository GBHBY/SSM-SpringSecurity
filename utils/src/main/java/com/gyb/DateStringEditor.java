package com.gyb;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author gb
 * @Date 2020/7/29 17:47
 * @Version 1.0
 * description:日期与字符串转换
 */

public class DateStringEditor extends PropertiesEditor {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/29 17:48
     * @param 
     * @return 
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date date = DateUtils.stringStoDate(text, "yyyy-MM-dd HH:mm");
            super.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
