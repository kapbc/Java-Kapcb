package com.kapcb.ccc.thread.sync;

/**
 * <a>Title: A </a>
 * <a>Author: Kapcb <a>
 * <a>Description: A <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/3/1 22:11
 * @since 1.0
 */
public class A {

    private static Object instance = new Object();

    public static void funOne() throws InterruptedException {
        synchronized (instance) {
            System.out.println("function one begin to transfer wait");
            instance.wait();
        }
    }

    public static void funTwo() {
        synchronized (instance) {
            System.out.println("function two begin to transfer notify");
            instance.notify();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                funOne();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> funTwo()).start();
    }
}
