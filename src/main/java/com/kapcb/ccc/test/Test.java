package com.kapcb.ccc.test;

import com.kapcb.ccc.java.tos.Employee;
import com.kapcb.ccc.util.Constants;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

/**
 * <a>Title: Test </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/2-9:59
 */
public class Test {

    public static void main(String[] args) {

        Integer a = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String format = decimalFormat.format(a);
        System.out.println("format = " + format);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime of = LocalDateTime.of(2021, 12, 13, 13, 11, 32, 12);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d ,yyyy");
        String format1 = dateTimeFormatter.format(now);
        System.out.println("format1 = " + format1);

        String format2 = dateTimeFormatter.format(of);
        System.out.println("format2 = " + format2);

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String kapcb = stringStringHashMap.getOrDefault("kapcb", null);
        System.out.println("kapcb = " + kapcb);

        Employee employee = new Employee();
        System.out.println("employee = " + employee);
        employee = null;
        System.out.println("employee1 = " + employee);

        Employee employee1 = Optional.ofNullable(employee).orElseGet(Employee::new);
        System.out.println("employee2 = " + employee1);

        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String format3 = dateTimeFormatter1.format(now1);
        System.out.println("format3 = " + format3);

        System.out.println("File.separator = " + File.separator);


        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_12.getStringStatusCode(), Locale.CHINESE);
        LocalDateTime min = LocalDateTime.MIN;
        System.out.println("min = " + min);
        String format4 = dateTimeFormatter2.format(min);
        System.out.println("format4 = " + format4);

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2022);
        instance.set(Calendar.DAY_OF_MONTH, 2);
        instance.set(Calendar.MONTH, 2);
        Date time = instance.getTime();
        System.out.println("time = " + time);

        boolean equals = Objects.equals(true, false);
        System.out.println("equals = " + equals);
        boolean equals1 = Objects.equals(null, false);
        System.out.println("equals1 = " + equals1);

        Date date = new Date();
        System.out.println("date = " + date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String format5 = simpleDateFormat.format(date);
        System.out.println("format5 = " + format5);
    }
}
