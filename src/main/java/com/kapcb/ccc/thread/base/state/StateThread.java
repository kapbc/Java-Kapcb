package com.kapcb.ccc.thread.base.state;

/**
 * <a>Title: StateThread </a>
 * <a>Author: Kapcb <a>
 * <a>Description: StateThread <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/26 21:47
 * @since 1.0
 */
public class StateThread extends Thread {

    private boolean stopped;

    public StateThread() {
        this.stopped = false;
    }

    public StateThread(boolean stopped) {
        this.stopped = stopped;
    }

    @Override
    public void run() {
        while (!stopped) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is transfer State Thread's run method!");
        }
    }

    public void stopStateThread() {
        if (!this.stopped) {
            this.stopped = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StateThread stateThread = new StateThread();
        stateThread.start();
        Thread.sleep(5000);
        // 通知线程 state thread 关闭
        stateThread.stopStateThread();
        // 等待线程 state thread 退出 while 循环, 让线程自行退出
        stateThread.join();
    }

}
