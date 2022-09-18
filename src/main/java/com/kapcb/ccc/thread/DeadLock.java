package com.kapcb.ccc.algorithm.thread.philosopher;

/**
 * <a>Title: DeadLock </a>
 * <a>Description: DeadLock <a>
 * 五个则学家，无双筷子，就坐吃饭
 *
 * @version 1.0
 * @date 2022/9/12 23:50
 * @since 1.0
 */
public class DeadLock {

    // 死锁问题演示
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

    // 每个人都抢到左手边的筷子，则成环死锁
    public static class Philosopher extends Thread {

        // 左边的筷子
        private ChopStick left;

        // 右边的筷子
        private ChopStick right;

        // 序号
        private int index;

        public Philosopher(String name, ChopStick left, ChopStick right, int index) {
            this.setName(name);
            this.left = left;
            this.right = right;
            this.index = index;
        }

        @Override
        public void run() {
            synchronized (left) {
                try {
                    // 保证每个则学家都抢到左边的筷子，造成死锁
                    Thread.sleep(index + 1);
                    synchronized (right) {
                        Thread.sleep(1);
                        System.out.println("[ " + index + " ] 号则学家已经吃完了");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
