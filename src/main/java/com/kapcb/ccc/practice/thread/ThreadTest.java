package com.kapcb.ccc.practice.thread;

import com.kapcb.ccc.util.KapcbStartUp;

import java.util.logging.Logger;

/**
 * <a>Title: ThreadTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/1-17:03
 */
public class ThreadTest {

    private static final int DELAY = 10;
    private static final int STEPS = 100;
    private static final double MAX_ACCOUNT = 1000;

    private static final Logger logger = Logger.getLogger(String.valueOf(ThreadTest.class), "logmessage_en");

    public static void main(String[] args) {
        KapcbStartUp.kapcbUp();
        Bank bank = new Bank(4, 10000);

        new Thread(() -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_ACCOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    int sleepTime = (int) (DELAY * Math.random());
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                logger.warning("System exception= " + e.getMessage());
            }
        }, "Thread A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_ACCOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    int sleepTime = (int) (DELAY * Math.random());
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                logger.warning("System exception= " + e.getMessage());
            }
        }, "Thread B").start();
    }
}
