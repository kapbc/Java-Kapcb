package com.kapcb.ccc.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    }

    private static <T> String convertData(T data, Function<T, String> function) {
        return data == null ? null : function.apply(data);
    }
}
