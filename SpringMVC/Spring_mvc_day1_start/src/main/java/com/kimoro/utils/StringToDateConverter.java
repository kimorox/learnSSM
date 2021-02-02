package com.kimoro.utils;

import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;

import javax.xml.transform.Source;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName StringToDateConverter
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/28 15:55
 **/
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s == null){
            throw new RuntimeException("请宁传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
