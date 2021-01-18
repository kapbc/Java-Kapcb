package com.kapcb.ccc.java.juc.cas;

import java.util.concurrent.TimeUnit;

/**
 * <a>Title: ThreadCas </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/18-11:19
 */
public class ThreadCas {
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
                    count++;
                }
            }, "Thread-" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * count 输出的值并非期望中的 200 , 因为线程并不是安全的
         */
        System.out.println("count = " + count);
    }
}
