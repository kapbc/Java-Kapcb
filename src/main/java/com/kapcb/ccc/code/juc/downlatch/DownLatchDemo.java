package com.kapcb.ccc.code.juc.downlatch;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: DownLatchDemo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/13 - 13:30
 */
public class DownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(Constants.COMMON_NUMBER_SIX.getNumberStatusCode());

        for (int i = 6; i > 0; i--) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " left the classroom");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println("All student left the classroom, Monitor close the door!");
    }
}
