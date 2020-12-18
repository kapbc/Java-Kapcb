package com.kapcb.ccc.java.time.convert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: LocalDateToString </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18-10:26
 */
public class LocalDateToString {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String localDateToString = dateTimeFormatter.format(localDate);
        System.out.println("localDateToString = " + localDateToString);
    }
}
