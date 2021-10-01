package com.kapcb.ccc.code.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <a>Title: AtomicBooleanCas </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/18-11:38
 */
public class AtomicBooleanCas implements Runnable {

    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        AtomicBooleanCas atomicBooleanCas = new AtomicBooleanCas();
        new Thread(atomicBooleanCas).start();
        new Thread(atomicBooleanCas).start();
    }

    @Override
    public void run() {
        System.out.println("Thread-" + Thread.currentThread().getName() + "; flag : " + flag.get());
        if (flag.compareAndSet(true, false)) {
            System.out.println("Current Thread is : " + Thread.currentThread().getName() + "; flag is : " + flag.get());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        } else {
            System.out.println("重试机制 Current Thread is : " + Thread.currentThread().getName() + "; flag is : " + flag.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**
             * 递归调用 run() 方法进行重试
             */
            run();
        }
    }
}
