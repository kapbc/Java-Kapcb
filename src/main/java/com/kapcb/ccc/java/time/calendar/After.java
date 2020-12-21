package com.kapcb.ccc.java.time.calendar;

import com.kapcb.ccc.util.Constants;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        System.out.println("time = " + time);
        LocalDateTime afterPervWeekMonday = LocalDateTime.of(2020, 12, 14, 0, 0, 1, 120);
        LocalDateTime beforePervWeekMonday = LocalDateTime.of(2020, 12, 13, 23, 59, 59, 999);
        Date afterPervWeekMondayDate = Date.from(afterPervWeekMonday.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("afterPervWeekMondayDate = " + afterPervWeekMondayDate);
        Date beforePervWeekMondayDate = Date.from(beforePervWeekMonday.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("beforePervWeekMondayDate = " + beforePervWeekMondayDate);
        System.out.println("After : " + afterPervWeekMondayDate.after(time));
        System.out.println("Before : " + beforePervWeekMondayDate.after(time));
    }
}
