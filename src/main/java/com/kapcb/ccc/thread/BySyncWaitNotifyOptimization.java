package com.kapcb.ccc.algorithm.thread.output;

import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: BySyncWaitNotifyOptimization </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BySyncWaitNotifyOptimization <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/13 10:42 PM
 * @since 1.0
 */
public class BySyncWaitNotifyOptimization {

    static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {

        final Object o = new Object();

        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        new Thread(() -> {
            // 等待线程t2先输出
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (o) {
                try {
                    for (char c : aI) {
                        System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                o.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {

                try {
                    for (char c : aC) {
                        System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                        // t2线程输出完之后，拉下latch
                        latch.countDown();

                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                o.notify();

            }
        }, "t2").start();
    }
}
