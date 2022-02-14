package com.kapcb.ccc.synchronize.sync;

/**
 * <a>Title: CodeBlockSync </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CodeBlockSync <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/14 21:21
 * @since 1.0
 */
public class CodeBlockSync implements Runnable {

    static final CodeBlockSync instance = new CodeBlockSync();

    static int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (instance) {
                count++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(instance);
        Thread threadTwo = new Thread(instance);

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("count = " + count);
    }

}
