package com.kapcb.ccc.java.time.convert;

import com.kapcb.ccc.util.Constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: StringToLocalDateAndLocalDateTime </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18-10:45
 */
public class StringToLocalDateAndLocalDateTime {

    public static void main(String[] args) {
        String timeStamp = "2020-11-21 14:41:06:612";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        LocalDate localDateParse = LocalDate.parse(timeStamp, dateTimeFormatter);
        System.out.println("localDateParse = " + localDateParse);

        LocalDateTime localDateTimeParse = LocalDateTime.parse(timeStamp, dateTimeFormatter);
        System.out.println("localDateTimeParse = " + localDateTimeParse);
    }
}
