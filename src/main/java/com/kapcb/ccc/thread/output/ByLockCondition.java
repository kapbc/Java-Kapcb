package com.kapcb.ccc.thread.output;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <a>Title: AlternateOutputByLockCondition </a>
 * <a>Description: AlternateOutputByLockCondition <a>
 *
 * @version 1.0
 * @date 2022/9/13 0:51
 * @since 1.0
 */
public class ByLockCondition {

    static Thread t1;
    static Thread t2;

    public static void main(String[] args) {

        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        PrintMachine printMachine = new PrintMachine(aC, aI);

        t1 = new Thread(printMachine::printNumber, "t1");

        t2 = new Thread(printMachine::printChar, "t2");

        t1.start();
        t2.start();
    }

    private static class PrintMachine {

        private static int machine = 1;
        private Lock lock = new ReentrantLock();
        private Condition conditionOne = lock.newCondition();
        private Condition conditionTwo = lock.newCondition();

        private char[] aC;

        private char[] aI;

        public PrintMachine(char[] aC, char[] aI) {
            this.aC = aC;
            this.aI = aI;
        }

        public void printNumber() {

            lock.lock();
            try {
                for (char c : aI) {
                    while (machine != 1) {
                        conditionOne.await();
                    }
                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                    machine = 2;
                    conditionTwo.signal();
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printChar() {
            lock.lock();
            try {
                for (char c : aC) {
                    // 如果不是当前线程打印
                    while (machine != 2) {
                        // 自旋等待
                        conditionTwo.await();
                    }
                    // 打印输出
                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                    // 此时应该进行交替打印，修改机器编号
                    machine = 1;
                    // 唤醒另外一个线程
                    conditionOne.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

    }

}
