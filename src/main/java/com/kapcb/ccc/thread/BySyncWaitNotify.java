package com.kapcb.ccc.algorithm.thread.output;

/**
 * <a>Title: SyncWaitNotify </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SyncWaitNotify <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/13 10:20 PM
 * @since 1.0
 */
public class BySyncWaitNotify {

    public static void main(String[] args) {

        final Object o = new Object();

        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        new Thread(() -> {
            synchronized (o) {
                for (char c : aI) {
                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");

                    try {
                        // 唤醒其它等待线程
                        o.notify();
                        // 让出锁
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                // 必须，否则执行完最后一次循环后线程将一直处于wait状态
                o.notify();
            }
        }, "t1").start();


        new Thread(() -> {
            synchronized (o) {
                for (char c : aC) {
                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");

                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                o.notify();
            }
        }, "t2").start();
    }

}
