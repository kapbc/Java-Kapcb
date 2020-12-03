package com.kapcb.ccc.practice.thread;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * <a>Title: Bank </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/3-10:14
 */
public class Bank {

    private static final Logger logger = Logger.getLogger(String.valueOf(Bank.class), "logmessage_en");

    private final double[] accounts;

    /**
     * Constructs the Bank
     */
    public Bank() {
        this.accounts = new double[10];
    }

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfer money from one account to another
     *
     * @param form   int
     * @param to     int
     * @param amount double
     */
    public void transfer(int form, int to, double amount) {
        if (accounts[form] < amount) {
            return;
        }
        //logger.warning("currentThread: " + Thread.currentThread());
        System.out.println(Thread.currentThread());
        accounts[form] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, form, to);
        accounts[to] += amount;
        System.out.printf(". Total Balance: %10.2f%n", getTotalBalance());
    }

    /**
     * get the total balance of all account balance
     *
     * @return double
     */
    public double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    /**
     * get the number of the accounts in the bank
     *
     * @return int
     */
    public int size() {
        return accounts.length;
    }
}
