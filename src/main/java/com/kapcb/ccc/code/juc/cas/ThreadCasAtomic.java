package com.kapcb.ccc.code.juc.cas;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a>Title: ThreadCasAutomic </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/18-11:32
 */
public class ThreadCasAtomic {

    private static AtomicInteger atomicCount = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**
                 * 使用AtomicInteger之后，最终的输出结果同样可以保证是200
                 * 并且在某些情况下，代码的性能会比Synchronized更好
                 * Atomic操作的底层实现正是利用的CAS
                 */
                for (int j = 0; j < 100; j++) {
                    atomicCount.incrementAndGet();
                }
            }, "Thread-" + i).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("atomicCount = " + atomicCount);
    }
}
