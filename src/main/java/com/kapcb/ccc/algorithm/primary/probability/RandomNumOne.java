package com.kapcb.ccc.algorithm.primary.probability;

/**
 * <a>Title: RandomNumOne </a>
 * <a>Description: RandomNumOne <a>
 *
 * @version 1.0
 * @date 2022/8/28 20:20
 * @since 1.0
 */
public class RandomNumOne {

    /**
     * 从1 ~ 5随机等概率到1~7随机等概率:
     * 给定一个函数f1, 函数f1是1 ~ 5等概率随机, 实现一个方法达到1 ~7随机
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int count = 0;
        int testTimes = 10000000;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("============================");

        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = f3();
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "这个数, 出现了 : " + counts[i] + " 次数!");
        }

        System.out.println("============================");

        counts = new int[7];
        for (int i = 0; i < testTimes; i++) {
            int num = f4();
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "这个数, 出现了 : " + counts[i] + " 次数!");
        }

        System.out.println("============================");

        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = f5();
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "这个数, 出现了 : " + counts[i] + " 次数!");
        }

    }

    /**
     * 1 ~ 7之间等概率随机
     *
     * @return int
     */
    private static int f5() {
        return f4() + 1;
    }

    /**
     * 0 ~ 6之间等概率随机
     *
     * @return int
     */
    private static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    /**
     * 0 ~ 7之间等概率随机, 需要3个二进制位
     *
     * @return int
     */
    private static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2());
    }

    /**
     * 0 ~ 1之间等概率随机
     *
     * @return int
     */
    private static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        // 1、2的时候返回0, 4、5的时候返回1
        return ans < 3 ? 0 : 1;
    }

    /**
     * 1 ~ 5等概率随机
     *
     * @return int
     */
    private static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

}
