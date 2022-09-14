package com.kapcb.ccc.thread.output;

import java.util.concurrent.locks.LockSupport;

/**
 * <a>Title: LockSupportWay </a>
 * <a>Author: Kapcb <a>
 * <a>Description: LockSupportWay <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/14 11:14 PM
 * @since 1.0
 */
public class LockSupportWay {

    static Thread A;

    static Thread B;

    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        A = new Thread(() -> {

            for (char c : aI) {
                LockSupport.park();
                System.out.println("thread [ " + Thread.currentThread().getName() + " ] output : [ " + c + " ]");
                LockSupport.unpark(B);
            }
        }, "A");

        B = new Thread(() -> {
            for (char c : aC) {
                System.out.println("thread [ " + Thread.currentThread().getName() + " ] output : [ " + c + " ]");
                LockSupport.unpark(A);
                LockSupport.park();
            }
        }, "B");

        A.start();
        B.start();

    }

}
