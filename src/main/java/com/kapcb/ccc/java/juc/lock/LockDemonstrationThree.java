package com.kapcb.ccc.java.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * <a>Title: LockDemonstrationThree </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/12 - 22:13
 */
public class LockDemonstrationThree {

    public static void main(String[] args) {

        Phone phoneOne = new Phone();
        Phone phoneTwo = new Phone();

        new Thread(() -> {
            try {
                phoneOne.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            phoneTwo.sayHello();
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
            System.out.println("say Hello");
        }
    }
}
