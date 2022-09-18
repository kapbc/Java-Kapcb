package com.kapcb.ccc.algorithm.thread.output;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <a>Title: AlternateOutputByLockConditionOptimization </a>
 * <a>Description: AlternateOutputByLockConditionOptimization <a>
 *
 * @version 1.0
 * @date 2022/9/13 12:50
 * @since 1.0
 */
public class ByLockConditionOptimization {

    static Thread t1;

    static Thread t2;

    public static void main(String[] args) {
        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        PrintMachine printMachine = new PrintMachine(aC, aI);

        t1 = new Thread(printMachine::printChar, "t1");
        t2 = new Thread(printMachine::printNumber, "t2");

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

        public void printChar() {
            print(1, 2, aC, conditionOne, conditionTwo);
        }

        public void printNumber() {
            print(2, 1, aI, conditionTwo, conditionOne);
        }

        private void print(int currentMachine, int signalMachine, char[] printChar, Condition currentCondition, Condition conditionForSignal) {

            lock.lock();
            try {

                for (char c : printChar) {

                    while (machine != currentMachine) {
                        currentCondition.await();
                    }

                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");

                    machine = signalMachine;

                    conditionForSignal.signal();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }
    }


}
