package com.kapcb.ccc.thread.output;

import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: SyncWaitNotify </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SyncWaitNotify <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/14 10:54 PM
 * @since 1.0
 */
public class SyncWaitNotify {

    private static CountDownLatch latch = new CountDownLatch(1);

    /**
     * 华为：
     * 两个线程交替输出
     *
     * @param args
     */
    public static void main(String[] args) {

        final Object o = new Object();

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {

            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (o) {

                try {
                    for (char c : aI) {
                        System.out.println("thread [ " + Thread.currentThread().getName() + " ] output : [ " + c + " ]");
                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                o.notify();
            }
        }, "A").start();

        new Thread(() -> {

            synchronized (o) {
                try {
                    for (char c : aC) {
                        System.out.println("thread [ " + Thread.currentThread().getName() + " ] output : [ " + c + " ]");
                        latch.countDown();
                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                o.notify();
            }
        }, "B").start();

    }

}
