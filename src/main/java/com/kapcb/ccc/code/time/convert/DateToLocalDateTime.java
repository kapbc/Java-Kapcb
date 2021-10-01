package com.kapcb.ccc.code.time.convert;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * <a>Title: DateToLocalDateTime </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18-10:20
 */
public class DateToLocalDateTime {

    public static void main(String[] args) {
        Date todayDate = new Date();
        System.out.println("todayDate = " + todayDate);

        LocalDateTime localDateTime = todayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("localDateTime = " + localDateTime);
    }
}
