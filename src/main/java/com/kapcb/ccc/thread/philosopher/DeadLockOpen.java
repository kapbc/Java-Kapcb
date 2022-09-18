package com.kapcb.ccc.thread.philosopher;

/**
 * <a>Title: DeadLockOpen </a>
 * <a>Description: DeadLockOpen <a>
 *
 * @version 1.0
 * @date 2022/9/13 0:14
 * @since 1.0
 */
public class DeadLockOpen {

    public static void main(String[] args) {
        ChopStick cs0 = new ChopStick();
        ChopStick cs1 = new ChopStick();
        ChopStick cs2 = new ChopStick();
        ChopStick cs3 = new ChopStick();
        ChopStick cs4 = new ChopStick();

        Philosopher p0 = new Philosopher("p0", cs0, cs1, 0);
        Philosopher p1 = new Philosopher("p1", cs1, cs2, 1);
        Philosopher p2 = new Philosopher("p2", cs2, cs3, 2);
        Philosopher p3 = new Philosopher("p3", cs3, cs4, 3);
        Philosopher p4 = new Philosopher("p4", cs4, cs1, 4);

        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

    public static class Philosopher extends Thread {

        private ChopStick left;

        private ChopStick right;

        private int index;

        public Philosopher(String name, ChopStick left, ChopStick right, int index) {
            this.setName(name);
            this.left = left;
            this.right = right;
            this.index = index;
        }

        @Override
        public void run() {

            if (index % 2 == 0) {
                synchronized (left) {
                    try {
                        Thread.sleep(1000L);
                        synchronized (right) {
                            Thread.sleep(1000L);
                            System.out.println("[ " + index + " ] 号则学家已经吃完了");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                synchronized (right) {
                    try {
                        Thread.sleep(1000L);
                        synchronized (left) {
                            Thread.sleep(1000L);
                            System.out.println("[ " + index + " ] 号则学家已经吃完了");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
