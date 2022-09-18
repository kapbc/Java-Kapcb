package com.kapcb.ccc.algorithm.leetcode.junior;

/**
 * <a>Title: GuessNumberHigherOrLower </a>
 * <a>Description: GuessNumberHigherOrLower <a>
 * <a href="https://leetcode.cn/problems/guess-number-higher-or-lower/">...</a>
 *
 * @version 1.0
 * @date 2022/8/28 13:11
 * @since 1.0
 */
public class GuessNumberHigherOrLower {

    private static final int NUMBER = 6;

    public static void main(String[] args) {
        int n = 10;
        int result = guessNumber(n);
        System.out.println("result = " + result);
    }

    private static int guessNumber(int n) {

        // 边界条件判断
        if (n == 1) {
            return n;
        }
        // 二分法猜数字
        return rank(1, n);
    }

    private static int rank(int l, int r) {

        // 边界条件判断
        if (l > r) {
            return -1;
        }

        // 获取中间值
        int mid = l + ((r - l) >> 1);

        // 从中间开始猜
        int guess = guess(mid);

        // 如果中间值就是目标值, 直接返回
        if (guess == 0) {
            return mid;
        } else if (guess == 1) {
            // 如果中间值比目标值小, 则目标值一定在(mid , r]区间中
            return rank(++mid, r);
        } else {
            // 如果中间值比目标值大, 则目标值一定在[l , mid)区间中
            return rank(l, --mid);
        }

    }

    private static int guess(int num) {
        if (NUMBER == num) {
            return 0;
        }
        return NUMBER > num ? 1 : -1;
    }

}
