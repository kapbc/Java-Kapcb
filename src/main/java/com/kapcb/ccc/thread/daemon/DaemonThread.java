package com.kapcb.ccc.thread.daemon;

/**
 * <a>Title: DaemonThread </a>
 * <a>Author: Kapcb <a>
 * <a>Description: DaemonThread <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/26 21:20
 * @since 1.0
 */
public class DaemonThread {

    public static void main(String[] args) {
        System.out.println("begin main thread");

        Thread thread = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + " thread is running now");

            try {
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + " thread sleep over!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A");

        thread.setDaemon(true);
        thread.start();

        System.out.println("main thread exit");
        System.out.println("---------------split line---------------");
    }

}
