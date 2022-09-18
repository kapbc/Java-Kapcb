package com.kapcb.ccc.algorithm.primary.array;

import java.util.Arrays;

/**
 * <a>Title: TwoSumInputArraySorted </a>
 * <a>Author: Kapcb <a>
 * <a>Description: TwoSumInputArraySorted <a>
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/8/27 10:25 PM
 * @since 1.0
 */
public class TwoSumInputArraySorted {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 4, 9, 56, 90};
        int[] ints = twoSum(numbers, 8);
        String result = Arrays.toString(ints);
        System.out.println("result = " + result);
        int[] ints1 = doublePoint(numbers, 8);
        String result1 = Arrays.toString(ints1);
        System.out.println("result1 = " + result1);
    }

    private static int[] doublePoint(int[] numbers, int target) {
        int len = numbers.length;

        int l = 0;
        int r = len - 1;

        while (l < r) {

            int i = target - numbers[l];

            if (i == numbers[r]) {
                return new int[]{l + 1, r + 1};
            }

            if (i > numbers[r]) {
                ++l;
            } else {
                --r;
            }

        }
        return new int[0];
    }


    private static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;

        for (int i = 0; i < len; i++) {
            int e = target - numbers[i];
            int rank = rank(numbers, e, i + 1, len - 1);
            if (rank != -1) {
                return new int[]{i + 1, rank + 1};
            }
        }

        return new int[0];
    }

    private static int rank(int[] numbers, int target, int l, int r) {

        if (l > r) {
            return -1;
        }

        int mid = l + ((r - l) >> 1);

        if (numbers[mid] == target) {
            return mid;
        }
        if (numbers[mid] > target) {
            return rank(numbers, target, l, --mid);
        }

        return rank(numbers, target, ++mid, r);

    }

}
