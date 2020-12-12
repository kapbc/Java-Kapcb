package com.kapcb.ccc.java.juc.lock;

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

        Thread.sleep(1000);

        new Thread(() -> {
            phone.sayHello();
        }, "B").start();

    }

    private static class Phone {
        public synchronized void sendEmail() throws InterruptedException {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("Send Email");
        }

        public synchronized void sendSMS() {
            System.out.println("Send SMS");
        }

        public void sayHello() {
            System.out.println("sayHello");
        }
    }
}
