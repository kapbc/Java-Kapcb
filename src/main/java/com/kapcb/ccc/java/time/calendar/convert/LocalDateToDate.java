package com.kapcb.ccc.java.time.convert;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * <a>Title: LocalDateToDate </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18-10:57
 */
public class LocalDateToDate {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("date = " + date);
    }
}
