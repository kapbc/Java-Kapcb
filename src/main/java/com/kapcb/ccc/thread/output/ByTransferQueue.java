package com.kapcb.ccc.thread.output;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * <a>Title: AlternateOutputByTransferQueue </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AlternateOutputByTransferQueue <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/13 9:31 PM
 * @since 1.0
 */
public class ByTransferQueue {

    /**
     * 同步队列
     *
     * @param args
     */
    public static void main(String[] args) {
        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] cI = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        // 容量为0的同步对列，生产者线程入队之后必须等待消费者线程消费
        TransferQueue<Character> queue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                for (char c : aI) {
                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + queue.take() + " ]");
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : cI) {
                    queue.transfer(c);
                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + queue.take() + " ]");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }

}
