package com.kapcb.ccc.practice.thread.synchroniz;

import com.kapcb.ccc.util.Constants;
import com.kapcb.ccc.util.KapcbStartUp;

import java.util.logging.Logger;

/**
 * <a>Title: SynchronizedBankTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/4-13:06
 */
public class SynchronizedBankTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(SynchronizedBankTest.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    private static final int DELAY = 10;
    private static final int STEPS = 100;
    private static final double MAX_ACCOUNT = 1000;

    public static void main(String[] args) {
        KapcbStartUp.kapcbUp();

        SynchronizedBank synchronizedBank = new SynchronizedBank(4, 10000);

        new Thread(() -> {
            for (int i = 0; i < STEPS; i++) {
                double amount = MAX_ACCOUNT * Math.random();
                try {
                    synchronizedBank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                } catch (InterruptedException e) {
                    logger.warning("kapcb.thread.test.exception");
                    logger.warning("Exception Information: " + e.getMessage());
                }
            }
        }, "Thread A").start();

        new Thread(() -> {
            for (int i = 0; i < STEPS; i++) {
                double amount = MAX_ACCOUNT * Math.random();
                try {
                    synchronizedBank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                } catch (InterruptedException e) {
                    logger.warning("kapcb.thread.test.exception");
                    logger.warning("Exception Information: " + e.getMessage());
                }
            }
        }, "Thread B").start();
    }
}
