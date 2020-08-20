package com.kapcb.ccc.pattern.lazy;

/**
 * <a>Title:ExectorThread</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *  线程类
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 22:16
 */
public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + lazySimpleSingleton);
    }
}
