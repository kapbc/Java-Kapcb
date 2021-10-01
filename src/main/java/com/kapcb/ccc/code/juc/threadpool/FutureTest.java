
package com.kapcb.ccc.code.juc.threadpool;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 * <a>Title: Future </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/31-15:46
 */
public class FutureTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(FutureTest.class));

    public static void main(String[] args) {
        BlockingDeque<Runnable> deque = new LinkedBlockingDeque<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, deque);
        Future<?> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                logger.warning(" error ::: " + e.getMessage());
            }
            Person person = new Person();
            person.call("kapcb");
        });
        boolean done = future.isDone();
        System.out.println("done = " + done);
        try {
            future.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            future.cancel(true);
            logger.warning("---future error---" + e.getMessage());
        }
        boolean cancelled = future.isCancelled();
        System.out.println("cancelled = " + cancelled);
        boolean done1 = future.isDone();
        System.out.println("done1 = " + done1);
        future.cancel(true);
        System.out.println("future.isCancelled() = " + future.isCancelled());
        System.out.println("future.isDone() = " + future.isDone());
    }

    private static class Person {
        private String name;
        private String email;

        public Person() {
        }

        public Person(String name, String email) {
            this.email = email;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }

        public void call(String name) {
            System.out.println("My name is : " + name);
        }
    }


}
