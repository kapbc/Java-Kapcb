package com.kapcb.ccc.code.juc.lock;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.TimeUnit;

/**
 * <a>Title: LockDemonstrationSeven </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/13 - 12:11
 */
public class LockDemonstrationSeven {

    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();

        /**
         * Shouldn't Access The Static Method From Instance , Just For Test!!!
         */
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();


        Thread.sleep(1000);
        new Thread(() -> {
            phone.sendSMS();
        }, "B").start();

    }

    /**
     * 一个是 静态同步代码块, 一个是非静态同步代码块, 前者锁的是当前Class对象, 后者锁的是当前实例对象。两者之间不存在竞态条件, 因Send Email需要睡4s 所以先打印Send SMS 3s 之后再打印Send Email
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
