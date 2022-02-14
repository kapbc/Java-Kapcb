package com.kapcb.ccc.synchronize.sync;

/**
 * <a>Title: CountAndAgeSync </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CountAndAgeSync <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/14 21:06
 * @since 1.0
 */
public class CountAndAgeSync implements Runnable{

    /**
     * 类变量
     */
    static int count = 0;

    /**
     * 对象变量
     */
    private int age = 0;

    private synchronized void increaseCount() {
        count++;
    }

    private synchronized void increaseAge() {
        age++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increaseCount();
        }
        for (int i = 0; i < 20; i++) {
            increaseAge();
        }
    }

    public int getAge() {
        return this.age;
    }

    public static void main(String[] args) throws InterruptedException {
        CountAndAgeSync countAndAgeSyncOne = new CountAndAgeSync();
        CountAndAgeSync countAndAgeSyncTwo = new CountAndAgeSync();
        Thread threadOne = new Thread(countAndAgeSyncOne);
        Thread threadTwo = new Thread(countAndAgeSyncTwo);

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("count = " + count);

        int ageOne = countAndAgeSyncOne.getAge();
        System.out.println("age one = " + ageOne);

        int ageTwo = countAndAgeSyncTwo.getAge();
        System.out.println("age two = " + ageTwo);
    }

}