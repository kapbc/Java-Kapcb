package com.kapcb.ccc.util;

import java.util.concurrent.TimeUnit;

/**
 * <a>Title: SleepHelper </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SleepHelper <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/14 9:22 PM
 * @since 1.0
 */
public class SleepHelper {

    private SleepHelper() {
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleepMill(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
