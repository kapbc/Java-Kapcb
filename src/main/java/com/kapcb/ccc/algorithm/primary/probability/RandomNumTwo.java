package com.kapcb.ccc.algorithm.primary.probability;

/**
 * <a>Title: RandomNumTwo </a>
 * <a>Description: RandomNumTwo <a>
 *
 * @version 1.0
 * @date 2022/8/28 22:30
 * @since 1.0
 */
public class RandomNumTwo {

    /**
     * 给定函数f1(), 以固定概率返回0或1, 但不是等概率
     * 实现一个函数以等概率返回0或者1
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int testTimes = 10000000;
        int[] counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            int num = f2();
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("数字 : " + i + " 出现了 : " + counts[i] + " 次数!");
        }

    }

    // 函数f2()等概率返回0或者1
    private static int f2() {
        int ans = 0;
        do {
            // ans不等概率返回0或者1
            ans = f1();
            // 如果再次调用f1(), 并且与ans相等, 则不等概率, 继续调用f1()
        } while (ans == f1());
        // ans = 0, 1;
        // ans = 1, 0;
        return ans;
    }

    // 函数会以固定概率返回0或者1, 但不是等概率
    private static int f1() {
        return Math.random() < 0.84 ? 0 : 1;
    }

}
