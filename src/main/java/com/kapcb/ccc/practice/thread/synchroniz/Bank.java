package com.kapcb.ccc.practice.thread.synchroniz;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * <a>Title: Bank </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/4-9:58
 */
public class Bank {

    private static final Logger logger = Logger.getLogger(String.valueOf(Bank.class), "logmessage_en");

    private Lock bankLock;

    private Condition sufficientFunds;

    private double[] account;

    public Bank() {
        account = new double[10];
        bankLock = new ReentrantLock(true);
        sufficientFunds = bankLock.newCondition();
    }

    public Bank(int n, double initialBalance) {
        account = new double[n];
        Arrays.fill(account, initialBalance);
        bankLock = new ReentrantLock(true);
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (account[from] < amount) {
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            account[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            account[to] += amount;
            System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }
    }

    private double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double v : account) {
                sum += v;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return account.length;
    }
}
