package com.kapcb.ccc.java.time.convert;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: Test </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/23-9:46
 */
public class Test {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String format = dateTimeFormatter.format(now);
        System.out.println("format = " + format);


        Integer point = 456115590;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String format1 = decimalFormat.format(point);
        System.out.println("format1 = " + format1);
    }
}
