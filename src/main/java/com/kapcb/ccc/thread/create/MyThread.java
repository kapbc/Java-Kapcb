package com.kapcb.ccc.thread.create;

/**
 * <a>Title: MyThread </a>
 * <a>Author: Kapcb <a>
 * <a>Description: MyThread <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/11 20:28
 * @since 1.0
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("current thread is : " + Thread.currentThread() + ", the first way to create Thread!");
    }

}
