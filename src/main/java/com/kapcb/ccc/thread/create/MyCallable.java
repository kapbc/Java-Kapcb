package com.kapcb.ccc.thread.create;

import java.util.concurrent.Callable;

/**
 * <a>Title: MyCallable </a>
 * <a>Author: Kapcb <a>
 * <a>Description: MyCallable <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/11 20:35
 * @since 1.0
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "current thread is : " + Thread.currentThread() + ", the third way to create Thread!";
    }

}
