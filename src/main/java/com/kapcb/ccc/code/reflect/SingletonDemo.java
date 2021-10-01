package com.kapcb.ccc.code.reflect;

/**
 * <a>Title: SingletonDemo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/22 - 21:08
 */
public class SingletonDemo {

    private static SingletonDemo SINGLETON_DEMO = null;

    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        if (SINGLETON_DEMO == null) {
            return SINGLETON_DEMO = new SingletonDemo();
        }
        return SINGLETON_DEMO;
    }

    public static void main(String[] args) {

        SingletonDemo instance = SingletonDemo.getInstance();
        /**
         * 输出对象的地址，如果有地址存在，则说明对象创建成功并获取到
         */
        System.out.println("instance = " + instance);

        SingletonDemo instanceOne = SingletonDemo.getInstance();
        System.out.println("instanceOne = " + instanceOne);

        /**
         * 如果结果为true，则说明是同一个对象
         */
        System.out.println(instance == instanceOne);
    }

}
