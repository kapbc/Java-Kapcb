package com.kapcb.ccc.java.juc.executor;

import com.kapcb.ccc.util.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: WorkThread </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/20 - 21:38
 */
public class WorkThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Started. Current Time is : " + getLocalTime());
        sleep();
        System.out.println(Thread.currentThread().getName() + " Ended. Current Time is : " + getLocalTime());
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getLocalTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_24.getStringStatusCode());
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}
