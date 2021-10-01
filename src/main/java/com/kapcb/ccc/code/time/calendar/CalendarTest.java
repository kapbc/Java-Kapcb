package com.kapcb.ccc.code.time.calendar;


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


    /**
     * 由于国外周日为下周一, 所以需要获取当周的周日, 需要在当前时间基础上添加 7 天, 即将当前时间设置为下周的改天, 然后再获取SUNDAY即为本周的周日
     * <p>
     * 上周日为当前周的周一(相对于国外), 所以获取上周日只需要在当前日期回退到上周的当前时间即可, 获取上周日即为当前周的SUNDAY即可
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarChina = Calendar.getInstance(Locale.CHINA);

        // 获取当前时间并格式化
        String currentChinaTime = simpleDateFormat.format(calendarChina.getTime());
        System.out.println("Current Time is: " + currentChinaTime);

        // 给当前时间加上天数days并输出, 第一个参数用以下三个都可以
        int addDays = 2;
        calendarChina.add(Calendar.DAY_OF_YEAR, addDays);
        currentChinaTime = simpleDateFormat.format(calendarChina.getTime());
        System.out.println("The Time That Have Added " + addDays + " Days Is : " + currentChinaTime);

        calendarChina.add(Calendar.DAY_OF_MONTH, addDays);
        currentChinaTime = simpleDateFormat.format(calendarChina.getTime());
        System.out.println("The Time That Have Added " + addDays + " Days Is : " + currentChinaTime);

        calendarChina.add(Calendar.DAY_OF_WEEK, addDays);
        currentChinaTime = simpleDateFormat.format(calendarChina.getTime());
        System.out.println("The Time That Have Added " + addDays + " Days Is : " + currentChinaTime);

        System.out.printf("\n");

        // 获取当前星期、前一星期、后一星期的第一天和最后一天
        Calendar calendarChinese = Calendar.getInstance(Locale.CHINESE);

        // 获取当前时间并格式化
        String currentChineseTime = simpleDateFormat.format(calendarChinese.getTime());
        System.out.println("Current Time is: " + currentChineseTime);

        // 本周一
        calendarChinese.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        currentChineseTime = simpleDateFormat.format(calendarChinese.getTime());
        System.out.println("Current Week Monday Time is : " + currentChineseTime);

        // 本周日
        // 外国的星期天为当前周的星期六, 星期天为下周一
        Calendar calendarForSunday = Calendar.getInstance(Locale.CHINESE);
        calendarForSunday.add(Calendar.DAY_OF_MONTH, 7);
        calendarForSunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        currentChineseTime = simpleDateFormat.format(calendarForSunday.getTime());
        System.out.println("Current Week Sunday Time is : " + currentChineseTime);
        System.out.printf("\n");

        // 下周一
        Calendar calendarForNextWeekMonday = Calendar.getInstance(Locale.CHINESE);
        currentChineseTime = simpleDateFormat.format(calendarForNextWeekMonday.getTime());
        System.out.println("Current Time is: " + currentChineseTime);
        calendarForNextWeekMonday.add(Calendar.DAY_OF_MONTH, 7);
        calendarForNextWeekMonday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String nextWeekMonday = simpleDateFormat.format(calendarForNextWeekMonday.getTime());
        System.out.println("Next Week Monday Time is : " + nextWeekMonday);
        System.out.printf("\n");

        // 下周日
        Calendar calendarForNextWeekSunday = Calendar.getInstance(Locale.CHINESE);
        currentChineseTime = simpleDateFormat.format(calendarForNextWeekSunday.getTime());
        System.out.println("Current Time is: " + currentChineseTime);
        calendarForNextWeekSunday.add(Calendar.DAY_OF_YEAR, 14);
        String dayAdd14 = simpleDateFormat.format(calendarForNextWeekSunday.getTime());
        calendarForNextWeekSunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String nextWeekSunday = simpleDateFormat.format(calendarForNextWeekSunday.getTime());
        System.out.println("Next Week Sunday Time is : " + nextWeekSunday);
        System.out.printf("\n");

        // 上周一
        Calendar calendarForPrevWeekMonday = Calendar.getInstance(Locale.CHINESE);
        currentChineseTime = simpleDateFormat.format(calendarForPrevWeekMonday.getTime());
        System.out.println("Current Time is : " + currentChineseTime);
        calendarForPrevWeekMonday.add(Calendar.DAY_OF_YEAR, -7);
        calendarForPrevWeekMonday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String prevWeekMonday = simpleDateFormat.format(calendarForPrevWeekMonday.getTime());
        System.out.println("Prev Week Monday Time is : " + prevWeekMonday);
        System.out.printf("\n");

        // 上周日
        Calendar calendarForPrevWeekSunday = Calendar.getInstance(Locale.CHINESE);
        currentChineseTime = simpleDateFormat.format(calendarForPrevWeekSunday.getTime());
        System.out.println("Current Time is : " + currentChineseTime);
        calendarForPrevWeekSunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String prevWeekSunday = simpleDateFormat.format(calendarForPrevWeekSunday.getTime());
        System.out.println("prevWeekSunday = " + prevWeekSunday);
    }
}
