package com.kapcb.ccc.java.juc.condition;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <a>Title: ConditionPrintOptimization </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/12 - 19:33
 */
public class ConditionPrintOptimization {

    private static final Logger logger = Logger.getLogger(String.valueOf(ConditionPrintOptimization.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {

        PrintMachine printMachine = new PrintMachine();

        function(3, PrintMachine::printForFive, "A", printMachine);
        function(3, PrintMachine::printForTen, "B", printMachine);
        function(3, PrintMachine::printFifteen, "C", printMachine);

    }

    private static void function(int count, Consumer<PrintMachine> consumer, String thread, PrintMachine printMachine) {
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                consumer.accept(printMachine);
            }
        }, thread).start();
    }

    private static class PrintMachine {

        private static int machineIndex = 1;
        private final Lock lock = new ReentrantLock();
        private final Condition conditionForFive = lock.newCondition();
        private final Condition conditionForTen = lock.newCondition();
        private final Condition conditionForFifteen = lock.newCondition();

        public void printForFive() {
            print(5,
                    conditionForFive,
                    conditionForTen,
                    Constants.COMMON_NUMBER_ONE.getNumberStatusCode(),
                    Constants.COMMON_NUMBER_TWO.getNumberStatusCode());
        }

        public void printForTen() {
            print(10,
                    conditionForTen,
                    conditionForFifteen,
                    Constants.COMMON_NUMBER_TWO.getNumberStatusCode(),
                    Constants.COMMON_NUMBER_THREE.getNumberStatusCode());
        }

        public void printFifteen() {
            print(15,
                    conditionForFifteen,
                    conditionForFive,
                    Constants.COMMON_NUMBER_THREE.getNumberStatusCode(),
                    Constants.COMMON_NUMBER_ONE.getNumberStatusCode());
        }

        private void print(int count, Condition conditionForHold, Condition conditionForSignal, int currentIndex, int signalIndex) {
            int frequency = count;
            lock.lock();
            try {
                while (machineIndex != currentIndex) {
                    conditionForHold.await();
                }
                for (int i = count; i > 0; i--) {
                    System.out.println("The Machine: " + Thread.currentThread().getName() +
                            " Has been print: " + Constants.COMMON_SYSTEM_OUT_PRINTLN_STRING.getStringStatusCode() +
                            " for: " + (frequency - i + 1) + " frequency");
                }
                machineIndex = signalIndex;
                conditionForSignal.signalAll();
            } catch (InterruptedException e) {
                logger.log(Level.WARNING,
                        Constants.COMMON_TRY_CATCH_EXCEPTION_INFO.getStringStatusCode() + e +
                                Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE + e.getMessage());
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
