package com.kapcb.ccc.code.juc.lock;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.TimeUnit;

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
     * 两个静态同步代码块, 锁的是当前Class对象, 线程之间共享Phone这一把锁 ,所以调用 先打印 Send Email 等待锁释放之后 再打印 Send SMS
     */
    private static class Phone {

        public static synchronized void sendEmail() throws InterruptedException {
            TimeUnit.SECONDS.sleep(4);
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_EMAIL.getStringStatusCode());
        }

        public static synchronized void sendSMS() {
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_SMS.getStringStatusCode());
        }
    }
}
