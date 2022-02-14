package com.kapcb.ccc.synchronize.sync;

/**
 * <a>Title: StaticCountAndAgeSync </a>
 * <a>Author: Kapcb <a>
 * <a>Description: StaticCountAndAgeSync <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/14 21:10
 * @since 1.0
 */
public class StaticCountAndAgeSync implements Runnable {

    static int count = 0;

    static int age = 0;

    /**
     * synchronized修饰静态方法, 锁是当前Class对象, 也就是
     * CountSync类对于的Class对象
     */
    private static synchronized void increaseCount() {
        count++;
    }

    /**
     * synchronized修饰普通方法, 同时访问实例同步方法和
     * 静态同步方法时由于锁对象不一样不会产生互斥
     */
    public synchronized void increaseAge() {
        age++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            increaseAge();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                StaticCountAndAgeSync.increaseCount();
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                StaticCountAndAgeSync.increaseCount();
            }
        });

        StaticCountAndAgeSync staticCountAndAgeSync = new StaticCountAndAgeSync();

        Thread threadThree = new Thread(staticCountAndAgeSync);
        Thread threadFour = new Thread(staticCountAndAgeSync);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();
        threadFour.join();

        System.out.println("count = " + count);

        System.out.println("age = " + age);

    }

}
