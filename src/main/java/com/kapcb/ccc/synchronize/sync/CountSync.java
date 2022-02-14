package com.kapcb.ccc.synchronize.sync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <a>Title: CountSync </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CountSync <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/14 20:39
 * @since 1.0
 */
public class CountSync implements Runnable {

    /**
     * 共享变量, 临界资源
     */
    static int count = 0;

    /**
     * synchronized 关键字修饰实例方法
     */
    private synchronized void increase() {
        count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountSync countSync = new CountSync();
        Thread threadOne = new Thread(countSync);
        Thread threadTwo = new Thread(countSync);
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("count = " + count);
    }

}
