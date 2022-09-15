package com.kapcb.ccc.thread.output;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <a>Title: ThreeThreadPrint1 </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ThreeThreadPrint1 <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/15 10:20 PM
 * @since 1.0
 */
public class ThreeThreadPrint1 {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        CountDownLatch latchB = new CountDownLatch(1);
        CountDownLatch latchC = new CountDownLatch(1);

        Thread A = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("A");
                    conditionB.signal();
                    if (i == 0) {
                        latchB.countDown();
                    }
                    conditionA.await();
                }

                conditionB.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }, "A");

        Thread B = new Thread(() -> {

            try {
                latchB.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("B");
                    conditionC.signal();
                    if (i == 0) {
                        latchC.countDown();
                    }
                    conditionB.await();
                }

                conditionC.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "B");

        Thread C = new Thread(() -> {

            try {
                latchC.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("C");
                    conditionA.signal();
                    conditionC.await();
                }

                conditionA.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "C");

        A.start();
        B.start();
        C.start();

    }


}
