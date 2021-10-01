package com.kapcb.ccc.code.juc.thread.synchroniz;

import com.kapcb.ccc.util.Constants;
import com.kapcb.ccc.util.KapcbStartUp;

import java.util.logging.Logger;

/**
 * <a>Title: BankTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/4-10:56
 */
public class BankTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(BankTest.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    private static final int DELAY = 10;
    private static final int STEPS = 100;
    private static final double MAX_ACCOUNT = 1000;

    public static void main(String[] args) {
        KapcbStartUp.kapcbUp();

        Bank bank = new Bank(4, 10000);

        new Thread(() -> {
            for (int i = 0; i < STEPS; i++) {
                double amount = MAX_ACCOUNT * Math.random();
                try {
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                } catch (InterruptedException e) {
                    logger.warning("kapcb.thread.test.exception");
                    logger.warning("Exception Information: " + e.getMessage());
                }
            }
        }, Constants.COMMON_THREAD_NAME_A.getStringStatusCode()).start();

        new Thread(() -> {
            for (int i = 0; i < STEPS; i++) {
                double amount = MAX_ACCOUNT * Math.random();
                try {
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                } catch (InterruptedException e) {
                    logger.warning("kapcb.thread.test.exception");
                    logger.warning("Exception Information: " + e.getMessage());
                }
            }
        }, Constants.COMMON_THREAD_NAME_B.getStringStatusCode()).start();
    }
}
