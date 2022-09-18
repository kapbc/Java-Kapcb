package com.kapcb.ccc.algorithm.leetcode.junior;

import java.util.Arrays;

/**
 * <a>Title: SquaresOfSortedArray </a>
 * <a>Description: SquaresOfSortedArray <a>
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">...</a>
 *
 * @version 1.0
 * @date 2022/8/26 17:09
 * @since 1.0
 */
public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{-7, -3, 2, 3, 11};
        int[] ints = sortedSquares(arr);
        System.out.println("result = " + Arrays.toString(ints));
    }

    private static int[] sortedSquares(int[] nums) {

        int len = nums.length;

        int[] result = new int[len];

        // 边界条件判断
        if (len == 0) {
            return result;
        }

        int left = 0;
        int right = len - 1;
        int index = len - 1;

        while (left <= right) {
            int i = nums[left] * nums[left];
            int j = nums[right] * nums[right];
            if (i > j) {
                result[index--] = i;
                left++;
            } else {
                result[index--] = j;
                right--;
            }
        }

        return result;
    }

}
