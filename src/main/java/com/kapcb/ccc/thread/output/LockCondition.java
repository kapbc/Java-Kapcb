package com.kapcb.ccc.thread.output;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <a>Title: LockCondition </a>
 * <a>Author: Kapcb <a>
 * <a>Description: LockCondition <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/14 11:02 PM
 * @since 1.0
 */
public class LockCondition {

    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();

        Condition conditionAI = lock.newCondition();
        Condition conditionAC = lock.newCondition();


        new Thread(() -> {
            lock.lock();
            try {

                for (char c : aI) {
                    conditionAC.signal();
                    conditionAI.await();
                    System.out.println("thread [ " + Thread.currentThread().getName() + " ] output : [ " + c + " ]");
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : aC) {
                    System.out.println("thread [ " + Thread.currentThread().getName() + " ] output : [ " + c + " ]");
                    conditionAI.signal();
                    conditionAC.await();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "B").start();
    }


}
