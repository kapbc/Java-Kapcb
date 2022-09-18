package com.kapcb.ccc.thread.output;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <a>Title: AlternateOutputByBlockingQueue </a>
 * <a>Description: AlternateOutputByBlockingQueue <a>
 *
 * @version 1.0
 * @date 2022/9/13 0:51
 * @since 1.0
 */
public class ByBlockingQueue {

    /**
     * https://github.com/RKiri/JUC2020/blob/main/src/main/java/com/weiyzue/juc/c_026_00_interview/A1B2C3/T06_00_sync_wait_notify.java
     */
    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {

        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        new Thread(() -> {

            try {
                for (char c : aI) {
                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                    q1.put("ok");
                    q2.take();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();

        new Thread(() -> {

            try {
                for (char c : aC) {
                    q1.take();
                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                    q2.put("ok");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2").start();

    }


}
