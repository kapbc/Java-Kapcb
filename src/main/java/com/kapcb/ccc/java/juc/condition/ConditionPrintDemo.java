package com.kapcb.ccc.java.juc.condition;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <a>Title: ConditionPrintDemo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/12 - 18:31
 * <p>
 * 三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次，接着，AA打印5次，BB打印10次，CC打印15次，来10轮
 */
public class ConditionPrintDemo {

    public static void main(String[] args) {
        PrintMachine printMachine = new PrintMachine();

        new Thread(() -> {
            for (int i = 3; i > 0; i--) {
                printMachine.printFive();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 3; i > 0; i--) {
                printMachine.printTen();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 3; i > 0; i--) {
                printMachine.printFifteen();
            }
        }, "C").start();

    }

    private static class PrintMachine {

        private static int machineNumber = 1;
        private Lock lock = new ReentrantLock();
        private Condition conditionForFive = lock.newCondition();
        private Condition conditionForTen = lock.newCondition();
        private Condition conditionForFifteen = lock.newCondition();

        public void printFive() {
            int count = 5;
            lock.lock();
            try {
                while (machineNumber != Constants.COMMON_NUMBER_ONE.getNumberStatusCode()) {
                    conditionForFive.await();
                }
                for (int i = count; i > 0; i--) {
                    System.out.println("The " + Thread.currentThread().getName() + " have been print: " + Constants.COMMON_SYSTEM_OUT_PRINTLN_STRING.getStringStatusCode());
                }
                machineNumber = Constants.COMMON_NUMBER_TWO.getNumberStatusCode();
                conditionForTen.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printTen() {
            int count = 10;
            lock.lock();
            try {
                while (machineNumber != Constants.COMMON_NUMBER_TWO.getNumberStatusCode()) {
                    conditionForTen.await();
                }
                for (int i = count; i > 0; i--) {
                    System.out.println("The " + Thread.currentThread().getName() + " have been print: " + Constants.COMMON_SYSTEM_OUT_PRINTLN_STRING.getStringStatusCode());
                }
                machineNumber = Constants.COMMON_NUMBER_THREE.getNumberStatusCode();
                conditionForFifteen.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printFifteen() {
            int count = 15;
            lock.lock();
            try {
                while (machineNumber != Constants.COMMON_NUMBER_THREE.getNumberStatusCode()) {
                    conditionForFifteen.await();
                }
                for (int i = count; i > 0; i--) {
                    System.out.println("The " + Thread.currentThread().getName() + " have been print: " + Constants.COMMON_SYSTEM_OUT_PRINTLN_STRING.getStringStatusCode());
                }
                machineNumber = Constants.COMMON_NUMBER_ONE.getNumberStatusCode();
                conditionForFive.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}
