package com.kapcb.ccc.java.juc.executor;

import com.kapcb.ccc.util.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: ScheduleThreadPollTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/20 - 21:52
 */
public class ScheduleThreadPollTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        try {
            System.out.println("Current Time is : " + getLocalTime());
            for (int i = 0; i < 3; i++) {
                TimeUnit.SECONDS.sleep(1);
                WorkThread workThread = new WorkThread();
                // 延迟 10s 执行
                scheduledExecutorService.schedule(workThread, 10, TimeUnit.SECONDS);

            }
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
        while (!scheduledExecutorService.isTerminated()) {
            // wait for all tasks to finish
        }
        System.out.println("Finished all threads");
    }

    public static String getLocalTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_24.getStringStatusCode());
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}
