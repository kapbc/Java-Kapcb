package com.kapcb.ccc.thread.output;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a>Title: AlternateOutputByAtomicInteger </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AlternateOutputByAtomicInteger <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/13 9:45 PM
 * @since 1.0
 */
public class ByAtomicInteger {

    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {

        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        new Thread(() -> {

            for (char c : aI) {
                while (atomicInteger.get() != 1) {

                }
                System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                atomicInteger.set(2);
            }
        }, "t1").start();

        new Thread(() -> {

            for (char c : aC) {
                while (atomicInteger.get() != 2) {

                }
                System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                atomicInteger.set(1);
            }
        }, "t2").start();

    }
}
