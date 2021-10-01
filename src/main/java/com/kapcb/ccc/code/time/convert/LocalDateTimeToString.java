package com.kapcb.ccc.code.time.convert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: LocalDateTimeToString </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18-10:33
 */
public class LocalDateTimeToString {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime testLocalDateTime = LocalDateTime.of(2021, 11, 24, 16, 22, 15, 715);
        // 使用预定义实例来转换
        DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;
        String localDateTimeToString = isoLocalDate.format(localDateTime);
        System.out.println("LocalDateTimeToString = " + localDateTimeToString);

        // 使用pattern来转换
        // 12小时制与24小时制输出由hh的大小写决定
        DateTimeFormatter dateTimeFormatter12 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SSS");
        String localDateTimeToString12 = dateTimeFormatter12.format(testLocalDateTime);
        System.out.println("localDateTimeToString12 = " + localDateTimeToString12);

        DateTimeFormatter dateTimeFormatter24 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        String localDateTimeToString24 = dateTimeFormatter24.format(testLocalDateTime);
        System.out.println("localDateTimeToString24 = " + localDateTimeToString24);

        // 如果想要给12小时制时间加上am/pm,这样子做
        DateTimeFormatter dateTimeFormatter12AmAndPm = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SSS a");
        String localDateTimeToString12AmAndPm = dateTimeFormatter12AmAndPm.format(testLocalDateTime);
        System.out.println("localDateTimeToString12AmAndPm = " + localDateTimeToString12AmAndPm);

        DateTimeFormatter dateTimeFormatter24AmAndPm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS a");
        String localDateTimeToString24AmAndPm = dateTimeFormatter24AmAndPm.format(testLocalDateTime);
        System.out.println("localDateTimeToString24AmAndPm = " + localDateTimeToString24AmAndPm);
    }
}
