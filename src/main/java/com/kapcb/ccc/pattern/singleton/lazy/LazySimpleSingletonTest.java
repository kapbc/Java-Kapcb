package com.kapcb.ccc.pattern.singleton.lazy;

/**
 * <a>Title:LazySimpleSingletonTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * 单例模式：懒汉式测试
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 22:24
 */
public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());
        thread1.start();
        thread2.start();
        System.out.println("End");
    }
}
