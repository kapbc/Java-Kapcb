package com.kapcb.ccc.java.juc.lock;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.TimeUnit;

/**
 * <a>Title: LockDemonstrationTwo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/12 - 21:54
 */
public class LockDemonstrationTwo {

    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(6000);

        new Thread(() -> {
            phone.sendSMS();
        }, "B").start();

    }

    /**
     * 两个普通同步代码块, 同一个实例对象访问非静态的同步代码块, 必须等待其它非静态方法释放锁之后才能再次获取锁访问同步代码块。
     * <p>
     * 等待 4s 后先打印 Send Email 2s 后再打印 Send SMS
     */
    private static class Phone {

        public synchronized void sendEmail() throws InterruptedException {
            TimeUnit.SECONDS.sleep(4);
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_EMAIL.getStringStatusCode());
        }

        public synchronized void sendSMS() {
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_SMS.getStringStatusCode());
        }

    }
}
