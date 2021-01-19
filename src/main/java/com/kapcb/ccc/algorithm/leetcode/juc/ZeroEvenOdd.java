package com.kapcb.ccc.algorithm.leetcode.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <a>Title: ZeroEvenOdd </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 * <p>
 * 打印零与奇偶数
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>
 * n = 5
 * "0102030405"
 * <p>
 * link : https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/19-10:09
 */
public class ZeroEvenOdd {

    public static void main(String[] args) {

        Print print = new Print();
        int printNumber = 2;
        int count = printNumber / 2;
        System.out.println("abs = " + count);

        new Thread(() -> {
            for (int i = 0; i < printNumber; i++) {
                print.Zero();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < printNumber - count; i++) {
                print.Even();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                print.Odd();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = print.getResult();
        System.out.println("result = " + result);

    }

    private static class Print {
        private volatile String result = "";
        private volatile static int count = 1;
        private final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        private final AtomicInteger atomicInteger = new AtomicInteger(0);
        private final Lock lock = new ReentrantLock();
        private final Condition conditionZero = lock.newCondition();
        private final Condition conditionEven = lock.newCondition();
        private final Condition conditionOdd = lock.newCondition();

        public void Zero() {
            lock.lock();
            try {
                while (count != 1) {
                    conditionZero.await();
                }
                result += "0";
                if (atomicBoolean.compareAndSet(true, false)) {
                    count = 2;
                    conditionEven.signalAll();
                    atomicBoolean.set(false);
                } else {
                    count = 3;
                    conditionOdd.signalAll();
                    atomicBoolean.set(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void Even() {
            lock.lock();
            try {
                while (count != 2) {
                    conditionEven.await();
                }
                result += atomicInteger.incrementAndGet();
                count = 1;
                conditionZero.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void Odd() {
            lock.lock();
            try {
                while (count != 3) {
                    conditionOdd.await();
                }
                result += atomicInteger.incrementAndGet();
                count = 1;
                conditionZero.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public String getResult() {
            return this.result;
        }
    }
}
