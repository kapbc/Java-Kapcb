package com.kapcb.ccc.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * <a>Title: ConvertData </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/28-10:12
 */
public class ConvertData {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime nu = null;

        String s = convertData(now, dateTimeFormatter::format);
        System.out.println("s = " + s);
        String s1 = convertData(nu, dateTimeFormatter::format);
        System.out.println("s1 = " + s1);

        String A = "Y";
        String B = "          ";
        String s2 = convertData(A, String::trim);
        System.out.println("s2 = " + s2);
        String s3 = convertData(B, String::trim);
        System.out.println("s3 = " + s3);

        String format = DATE_TIME_FORMATTER.format(now);
        System.out.println("format = " + format);
        String s4 = Objects.requireNonNull(A);
        System.out.println("s4 = " + s4);
        String C = null;
        //String s5 = Objects.requireNonNull(C);
        //System.out.println("s5 = " + s5);

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("now1 = " + now1);
        String format1 = now1.format(FORMATTER);
        System.out.println("format1 = " + format1);

        List<String> kapcb = testGet("kapcb");
        System.out.println(kapcb == null);
        System.out.println("kapcb.size() = " + kapcb.size());
    }

    private static <T> String convertData(T data, Function<T, String> function) {
        return data == null ? null : function.apply(data);
    }

    private static List<String> testGet(String name) {
        if (name != null) {
            System.out.println("name = " + name);
        }
        return new ArrayList<String>();
    }
}
