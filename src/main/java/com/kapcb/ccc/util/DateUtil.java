package com.kapcb.ccc.util;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <a>Title: DateUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/19 - 15:01
 */
public class DateUtil {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT_yyyy_MM_dd = new SimpleDateFormat(Constants.COMMON_TIME_FORMATTER_PATTERN_DAY.getStringStatusCode());

    private DateUtil() {
    }

    public static Date getDate() {
        return new Date();
    }

    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    private static boolean isAfter(Date target, Date when) {
        return target.after(when);
    }

    private static boolean isAfter(LocalDate target, LocalDate when) {
        return target.isAfter(when);
    }

    private static boolean isAfter(LocalDateTime target, LocalDateTime when) {
        return target.isAfter(when);
    }

    public static Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private static LocalDateTime convertLocalDateToLocalDateTime(LocalDate localDate) {
        return LocalDateTime.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    }

    private static LocalDate convertLocalDateTimeToLocalDate(LocalDateTime localDateTime) {
        return LocalDate.from(localDateTime.atZone(ZoneId.systemDefault()));
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_DAY.getStringStatusCode());
        String format = dateTimeFormatter.format(now);
        PrintUtil.print("The Current Time is: {0}\n", format);

        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_12.getStringStatusCode());
        LocalDateTime localDateTime = convertLocalDateToLocalDateTime(now);
        String format1 = localDateTimeFormatter.format(localDateTime);
        PrintUtil.print("Convert LocalDate To LocalDateTime is : {0}\n", format1);
    }
}
