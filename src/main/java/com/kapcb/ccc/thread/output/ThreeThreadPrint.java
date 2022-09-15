package com.kapcb.ccc.thread.output;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <a>Title: ThreeThreadPrint </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ThreeThreadPrint <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/15 12:03 AM
 * @since 1.0
 */
public class ThreeThreadPrint {

    /**
     * 三个线程交替打印输出ABC
     *
     * @param args
     */
    public static void main(String[] args) {
        PrintMachine printMachine = new PrintMachine();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printMachine.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printMachine.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printMachine.printC();
            }
        }, "C").start();

    }

    private static class PrintMachine {

        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        private Condition conditionC = lock.newCondition();

        private static int machineNum = 1;

        private void printA() {
            lock.lock();
            try {
                while (machineNum != 1) {
                    conditionA.await();
                }
                System.out.print("A");
                machineNum = 2;
                conditionB.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

        private void printB() {
            lock.lock();
            try {
                while (machineNum != 2) {
                    conditionB.await();
                }
                System.out.print("B");
                machineNum = 3;
                conditionC.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

        private void printC() {
            lock.lock();
            try {
                while (machineNum != 3) {
                    conditionC.await();
                }
                System.out.print("C");
                machineNum = 1;
                conditionA.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

}
