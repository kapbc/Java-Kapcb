package com.kapcb.ccc.algorithm.thread.output;

import java.util.concurrent.locks.LockSupport;

/**
 * <a>Title: AlternateOutputByLockSupport </a>
 * <a>Description: AlternateOutputByLockSupport <a>
 *
 * @version 1.0
 * @date 2022/9/13 0:39
 * @since 1.0
 */
public class ByLockSupport {


    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};


        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                // 唤醒t2线程
                LockSupport.unpark(t2);
                // 挂起当前线程
                LockSupport.park();
            }
        }, "A");

        t2 = new Thread(() -> {
            for (char c : aC) {
                // 挂起当前线程
                LockSupport.park();
                System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                // 唤醒t1线程
                LockSupport.unpark(t1);
            }
        }, "B");

        t1.start();
        t2.start();
    }


}
