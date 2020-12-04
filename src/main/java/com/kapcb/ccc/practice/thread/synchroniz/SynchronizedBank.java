package com.kapcb.ccc.practice.thread.synchroniz;

import java.util.Arrays;

/**
 * <a>Title: SynchronizedBank </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/4-11:41
 */
public class SynchronizedBank {

    private double[] account;

    public SynchronizedBank(int n, double initialBalance) {
        account = new double[n];
        Arrays.fill(account, initialBalance);

    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (account[from] < amount) {
            wait();
        }
        System.out.println(Thread.currentThread());
        account[from] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        account[to] += amount;
        System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double v : account) {
            sum += v;
        }
        return sum;
    }

    public int size() {
        return account.length;
    }

}
