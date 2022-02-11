package com.kapcb.ccc.thread.test;

import com.kapcb.ccc.thread.create.MyCallable;
import com.kapcb.ccc.thread.create.MyRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * <a>Title: ThreadPoolTest </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ThreadPoolTest <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/11 21:05
 * @since 1.0
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2 << 1);

        // 实例化，把对象传递给execute
        // 实现 Runnable 接口调用 execute
        // 相当于开启线程，去执行 MyRunnable 里的 run() 方法
        executorService.execute(new MyRunnable());

        executorService.execute(new Thread() {

            @Override
            public void run() {
                for (int i = 0; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }

        });

        // submit 适用于实现 Callable 接口
        MyCallable myCallable = new MyCallable();
        // 使用一个线程去执行 MyCallable 类的 call() 方法
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        // 线程池调线程不需要使用 start() 方法开启
        executorService.submit(futureTask);
        String callableResult = null;
        // 获取 call() 方法的返回值
        try {
            // get() 方法，调用返回值
            callableResult = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(callableResult);

        // 停止接受任何任务，已经提交完的任务还是会继续执行完
        executorService.shutdown();

    }
}
