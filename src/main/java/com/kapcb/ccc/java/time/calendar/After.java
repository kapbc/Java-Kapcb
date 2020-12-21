package com.kapcb.ccc.java.time.calendar;

import com.kapcb.ccc.util.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * <a>Title: After </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/21-8:58
 */
public class After {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24.getStringStatusCode());

    public static void main(String[] args) {
        String timeStamp = "2020-11-21 14:41:06:612";
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Time is : " + now);

        LocalDateTime parse = LocalDateTime.parse(timeStamp, DATE_TIME_FORMATTER);
        System.out.println("The Time Stamp is : " + parse);

        boolean after = now.isAfter(parse);
        System.out.println("after = " + after);

        Calendar instance = Calendar.getInstance();
    }
}
