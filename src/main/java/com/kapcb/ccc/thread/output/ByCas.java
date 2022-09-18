package com.kapcb.ccc.thread.output;

/**
 * <a>Title: ByCas </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ByCas <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/13 10:02 PM
 * @since 1.0
 */
public class ByCas {

    enum Running {
        T1,
        T2
    }

    static volatile Running r = Running.T1;

    public static void main(String[] args) {

        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        new Thread(() -> {

            for (char c : aI) {
                while (r != Running.T1) {

                }

                System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");

                r = Running.T2;

            }
        }, "t1").start();

        new Thread(() -> {

            for (char c : aC) {
                while (r != Running.T2) {

                }

                System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");

                r = Running.T1;

            }
        }, "t2").start();

    }
}
