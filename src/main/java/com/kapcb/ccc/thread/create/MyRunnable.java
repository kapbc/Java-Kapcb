package com.kapcb.ccc.thread.create;

/**
 * <a>Title: MyRunnable </a>
 * <a>Author: Kapcb <a>
 * <a>Description: MyRunnable <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/11 20:32
 * @since 1.0
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("current thread is : " + Thread.currentThread() + ", the second way to create Thread!");
    }

}
