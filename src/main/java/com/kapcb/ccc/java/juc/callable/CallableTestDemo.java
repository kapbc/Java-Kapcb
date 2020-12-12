package com.kapcb.ccc.java.juc.callable;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Logger;

/**
 * <a>Title: CallableTestDemo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/12 - 17:42
 */
public class CallableTestDemo {

    private static final Logger logger = Logger.getLogger(String.valueOf(CallableTestDemo.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThreadOne());

        new Thread(futureTask, Constants.COMMON_THREAD_NAME_A.getStringStatusCode()).start();

        Integer result = futureTask.get();
        System.out.println("result = " + result);

    }

    /**
     * Callable 接口有返回值
     */
    private static class MyThreadOne implements Callable<Integer> {

        /**
         * call() 方法有返回值
         *
         * @return T
         * @throws Exception exception
         */
        @Override
        public Integer call() throws Exception {
            logger.warning("CallableTestDemo Come Into The MyThreadOne's call Method");
            return 170224;
        }
    }

    /**
     * Runnable接口无返回值
     */
    private static class MyThreadTwo implements Runnable {

        /**
         * run() 方法无返回值
         */
        @Override
        public void run() {
            logger.warning("CallableTestDemo Come Into The MyThreadOne's run Method");
        }
    }
}
