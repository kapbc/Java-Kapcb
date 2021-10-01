package com.kapcb.ccc.code.juc.lock;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.TimeUnit;

/**
 * <a>Title: LockDemonstrationEight </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/13 - 12:15
 */
public class LockDemonstrationEight {

    public static void main(String[] args) throws InterruptedException {
        Phone phoneOne = new Phone();
        Phone phoneTwo = new Phone();

        /**
         * Shouldn't Access The Static Method From Instance , Just For Test!!!
         */
        new Thread(() -> {
            try {
                phoneOne.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(1000);


        new Thread(() -> {
            phoneTwo.sendSMS();
        }, "B").start();
    }

    /**
     * 不存在竞态条件, 先打印 Send SMS 再打印 Send Email
     */
    private static class Phone {
        public static synchronized void sendEmail() throws InterruptedException {
            TimeUnit.SECONDS.sleep(4);
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_EMAIL.getStringStatusCode());
        }

        public synchronized void sendSMS() {
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_SMS.getStringStatusCode());
        }
    }
}
