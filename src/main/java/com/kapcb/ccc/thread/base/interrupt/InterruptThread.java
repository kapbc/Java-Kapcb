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

    public void stopInterruptThread() {
        if (!stopped) {
            this.stopped = true;
        }
    }

    @Override
    public void run() {

        while (!stopped) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is transfer Interrupt Thread's run method!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptThread interruptThread = new InterruptThread();
        interruptThread.start();
        interruptThread.interrupt();
        Thread.sleep(500);
        interruptThread.stopInterruptThread();
        interruptThread.join();
    }

}
