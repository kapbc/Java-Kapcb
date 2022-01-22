package com.kapcb.ccc.jvm.classload;

/**
 * <a>Title: HelloClassLoader </a>
 * <a>Author: Kapcb <a>
 * <a>Description: HelloClassLoader <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/16 22:27
 * @since 1.0
 */
public class HelloClassLoader {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(getCurrentThreadName() + "开始");
            new DeadThread();
            System.out.println(getCurrentThreadName() + "结束");
        };

        Thread a = new Thread(runnable, "A线程");
        Thread b = new Thread(runnable, "B线程");

        a.start();
        b.start();
    }

    private static class DeadThread {
        static {
            System.out.println(getCurrentThreadName() + "正在初始化 [DeadThread] 类");
        }
    }

    private static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

}
