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
        System.out.println("currentTime = " + currentTime);
    }

}
