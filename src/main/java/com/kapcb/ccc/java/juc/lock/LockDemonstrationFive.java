package com.kapcb.ccc.java.juc.lock;

import com.kapcb.ccc.util.Constants;

/**
 * <a>Title: LockDemonstrationFive </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/13 - 11:44
 */
public class LockDemonstrationFive {

    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(() -> {

        }, "A").start();

        new Thread(() -> {

        }, "B").start();

    }

    private static class Phone {

        public static synchronized void sendEmail() {
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_EMAIL.getStringStatusCode());
        }

        public static synchronized void sendSMS() {
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_SMS.getStringStatusCode());
        }
    }
}
