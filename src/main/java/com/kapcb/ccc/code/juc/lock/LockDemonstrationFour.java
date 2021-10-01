package com.kapcb.ccc.code.juc.lock;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.TimeUnit;

/**
 * <a>Title: LockDemonstrationFour </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/12 - 23:12
 */
public class LockDemonstrationFour {

    public static void main(String[] args) throws InterruptedException {
        Phone phoneOne = new Phone();
        Phone phoneTwo = new Phone();

        new Thread(() -> {
            try {
                phoneOne.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(1000);

        new Thread(() -> {
            phoneTwo.sayHello();
        }, "B").start();
    }

    /**
     * 两个实例对象, 不会共享一把锁, 无需等待phoneOne对象的锁释放 ,所以先打印 say Hello 再打印 sendEmail
     */
    private static class Phone {

        public synchronized void sendEmail() throws InterruptedException {
            TimeUnit.SECONDS.sleep(4);
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_EMAIL.getStringStatusCode());
        }

        public synchronized void sendSMS() {
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_SMS.getStringStatusCode());
        }

        public void sayHello() {
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SAY_HELLO.getStringStatusCode());
        }
    }
}
