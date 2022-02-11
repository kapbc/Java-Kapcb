package com.kapcb.ccc.thread.test;

import com.kapcb.ccc.thread.create.MyCallable;
import com.kapcb.ccc.thread.create.MyRunnable;
import com.kapcb.ccc.thread.create.MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <a>Title: JavaThreadCreateTest </a>
 * <a>Author: Kapcb <a>
 * <a>Description: JavaThreadCreateTest <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/11 20:39
 * @since 1.0
 */
public class JavaThreadCreateTest {

    public static void main(String[] args) {
        // 线程的第一种常见方式
        MyThread myThread = new MyThread();
        myThread.start();

        // 线程的第二种创建方式
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        // 线程的第三种创建方式
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread futureTaskThread = new Thread(futureTask);
        futureTaskThread.start();
        String callableResult = null;
        try {
            callableResult = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(callableResult);


    }

}
