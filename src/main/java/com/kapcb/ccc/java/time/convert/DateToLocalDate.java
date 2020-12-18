package com.kapcb.ccc.java.time.convert;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * <a>Title: DateToLocalDate </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18-10:54
 */
public class DateToLocalDate {

    public static void main(String[] args) {
        Date today = new Date();
        System.out.println("today = " + today);

        LocalDate localDate = Instant.ofEpochMilli(today.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("localDate = " + localDate);
    }
}
