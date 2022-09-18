package com.kapcb.ccc.algorithm.thread.ali;

import com.kapcb.ccc.algorithm.util.SleepHelper;

/**
 * <a>Title: AsyncCallbackCancel </a>
 * <a>Description: AsyncCallbackCancel <a>
 *
 * @version 1.0
 * @date 2022/9/12 15:31
 * @since 1.0
 */
public class AsyncCallbackCancel {

    /**
     * 阿里巴巴：
     * 多线程异步处理任务，其中任意一个任务执行失败，其它线程全部回滚
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    private static enum Result {
        NOTSET, SUCCESSED, FAILED, CANCELLED
    }

    private static class Boss extends Thread {


    }

    private static class Worker extends Thread {

        private Result result = Result.NOTSET;

        private Boss boss;
        private String name;
        private int timeInSeconds;
        private boolean success;

        private volatile boolean canceling = false;

        public Worker(Boss boss, String name, int timeInSeconds, boolean success) {
            this.boss = boss;
            this.name = name;
            this.timeInSeconds = timeInSeconds;
            this.success = success;
        }

        public Result getResult() {
            return this.result;
        }

        @Override
        public void run() {

            int interval = 100;
            int total = 0;

            for (; ; ) {
                SleepHelper.sleepSeconds(interval);
                total += interval;

            }
        }
    }

}
