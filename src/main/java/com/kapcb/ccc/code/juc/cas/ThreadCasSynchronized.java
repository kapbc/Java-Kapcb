package com.kapcb.ccc.code.juc.cas;

import java.util.concurrent.TimeUnit;

/**
 * <a>Title: ThreadCasSynchronized </a>
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
                     *
                     * 但是 synchronized 会让没有获得资源的线程进入BLOCKED状态, 在上一个线程释放完资源后, 又重新让争夺到锁资源的线程恢复到 RUNNABLE状态
                     * 这个过程涉及到了操作系统用户模式和内核模式的转换, 代价比较高昂, 从性能上来说并不是最好的解决方案
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
