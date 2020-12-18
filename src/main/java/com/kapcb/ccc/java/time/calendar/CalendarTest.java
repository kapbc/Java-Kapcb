package com.kapcb.ccc.java.time.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * <a>Title: CalendarTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18-8:39
 */
public class CalendarTest {


    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 获取当前时间并格式化
        String currentTime = simpleDateFormat.format(calendar.getTime());
        System.out.println("Current Time is: " + currentTime);

        // 给当前时间加上天数days并输出, 第一个参数用以下三个都可以
        int addDays = 2;
        calendar.add(Calendar.DAY_OF_YEAR, addDays);
        currentTime = simpleDateFormat.format(calendar.getTime());
        System.out.println("The Time That Have Added " + addDays + " Days Is : " + currentTime);

        calendar.add(Calendar.DAY_OF_MONTH, addDays);
        currentTime = simpleDateFormat.format(calendar.getTime());
        System.out.println("The Time That Have Added " + addDays + " Days Is : " + currentTime);

        calendar.add(Calendar.DAY_OF_WEEK,addDays);
        currentTime = simpleDateFormat.format(calendar.getTime());
        System.out.println("The Time That Have Added " + addDays + " Days Is : " + currentTime);
        
    }
}
