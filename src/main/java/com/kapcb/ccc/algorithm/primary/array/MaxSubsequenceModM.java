package com.kapcb.ccc.algorithm.primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * <a>Title: MaxSubsequenceModM </a>
 * <a>Description: MaxSubsequenceModM <a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/9/10 10:57
 * @since 1.0
 */
public class MaxSubsequenceModM {

    /**
     * 给定一个非负数组arr，和一个正数m
     * 返回arr的所有子序列中累加和%m之后的最大值
     * 1、如果arr中每个数字不大，怎么做这道题？
     * 2、如果arr中m的值很小，怎么做这道题？
     * 3、如果arr的长度很短，但是arr每个数字比较大并且m比较小呢？
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 4, 6, 9, 4, 3, 2};
        int m = 5;
        int i = max1(arr, m);
        System.out.println("i = " + i);
        int i1 = max2(arr, m);
        System.out.println("i1 = " + i1);
    }

    /**
     * 时间复杂度O(2^n)，适用于累加和较大的场景
     *
     * @param arr
     * @param m
     * @return
     */
    private static int max1(int[] arr, int m) {

        if (arr == null || m == 0) {
            return -1;
        }

        Set<Integer> sumSet = new HashSet<>();

        process(arr, 0, 0, sumSet);

        int max = 0;
        for (Integer sum : sumSet) {
            max = Math.max(max, sum % m);
        }

        return max;

    }

    /**
     * @param arr    {@link int[]}
     * @param index  -> arr[index] 能够形成多少个不同的累加和，全部存放到Set中
     * @param sum    -> arr[0..index-1] 上所做的决定已经形成的累加和是多少
     * @param sumSet {@link Set<Integer>}
     */
    private static void process(int[] arr, int index, int sum, Set<Integer> sumSet) {
        if (index == arr.length) {
            sumSet.add(sum);
        } else {
            process(arr, index + 1, sum, sumSet);
            process(arr, index + 1, sum + arr[index], sumSet);
        }
    }

    /**
     * 时间复杂度 O(n*sum)，适用于累加和sum不太大的场景
     *
     * @param arr
     * @param m
     * @return
     */
    private static int max2(int[] arr, int m) {
        int sum = 0;

        int n = arr.length;

        for (int value : arr) {
            sum += value;
        }
        boolean[][] dp = new boolean[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;

        // 第0行不用管了
        // 第0列也不用管了
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                // dp[i][j]的构成：
                // 1、不使用arr[i]的数， 0...i-1的任务就是j
                dp[i][j] = dp[i - 1][j];
                // 2、使用arr[i]的数，0...i-1的任务就是j - arr[i]
                if (j - arr[i] >= 0) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - arr[i]];
                }
            }
        }

        int res = 0;
        for (int k = 0; k <= sum; k++) {
            if (dp[n - 1][k]) {
                res = Math.max(res, k % m);
            }
        }

        return res;
    }

}
