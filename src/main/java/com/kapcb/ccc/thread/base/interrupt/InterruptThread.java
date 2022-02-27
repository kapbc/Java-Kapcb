package com.kapcb.ccc.thread.base.interrupt;

/**
 * <a>Title: InterruptedFunction </a>
 * <a>Author: Kapcb <a>
 * <a>Description: InterruptedFunction <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/26 22:16
 * @since 1.0
 */
public class InterruptThread extends Thread {

    private boolean stopped;

    public InterruptThread() {
        this.stopped = false;
    }

    public void stopInterruptThread() throws InterruptedException {
        Thread.sleep(1);
        if (!stopped) {
            this.stopped = true;
        }
    }

    @Override
    public void run() {

        while (!stopped) {
            int a = 1;
            int b = 2;
            int c = a + b;
            System.out.println("result is : " + c);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        InterruptThread interruptThread = new InterruptThread();
        interruptThread.start();
        interruptThread.interrupt();
        interruptThread.stopInterruptThread();
        interruptThread.join();
    }

}
