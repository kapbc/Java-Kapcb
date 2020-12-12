package com.kapcb.ccc.java.juc.lock;

/**
 * <a>Title: LockDemonstrationOne </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/12 - 21:40
 */
public class LockDemonstrationOne {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendEmail();
        }, "A").start();

        Thread.sleep(3000);

        new Thread(() -> {
            phone.sendSMS();
        }, "B").start();
    }


    private static class Phone {
        public synchronized void sendEmail() {
            System.out.println("Send Email");
        }

        public synchronized void sendSMS() {
            System.out.println("Send SMS");
        }
    }
}
