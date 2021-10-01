package com.kapcb.ccc.code.time.convert;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * <a>Title: LocalDateTimeToDate </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18-10:24
 */
public class LocalDateTimeToDate {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("date = " + date);
    }
}
