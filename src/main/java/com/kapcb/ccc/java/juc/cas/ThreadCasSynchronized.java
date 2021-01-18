package com.kapcb.ccc.java.juc.cas;

import java.util.concurrent.TimeUnit;

/**
 * <a>Title: ThreadCasSynchornized </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/18-11:25
 */
public class ThreadCasSynchronized {

    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 100; j++) {
                    /**
                     * 增加 synchronized 同步锁, count 自增变成原子性操作, 最终输出与期望值一样为 200
                     */
                    synchronized (ThreadCasSynchronized.class) {
                        count++;
                    }
                }
            }, "Thread-" + i).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count = " + count);
    }
}
