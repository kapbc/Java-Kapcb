package com.kapcb.ccc.algorithm.primary.array;

import java.util.Arrays;

/**
 * <a>Title: RotateArray </a>
 * <a>Description: RotateArray <a>
 * <a href="https://leetcode.cn/problems/rotate-array/">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/8/27 12:38
 * @since 1.0
 */
public class RotateArray {

    public static void main(String[] args) {
//        int[] arr = new int[]{-1, -100, 3, 99};
//        int k = 2;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(arr, k);

        test(arr, k);
    }

    private static void rotate(int[] nums, int k) {
        int len = nums.length;

        k = k % len;

        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
        String result = Arrays.toString(nums);
        System.out.println("result = " + result);
    }

    private static void reverse(int[] nums, int begin, int end) {

        while (begin < end) {
            nums[begin] = nums[begin] ^ nums[end];
            nums[end] = nums[begin] ^ nums[end];
            nums[begin] = nums[begin] ^ nums[end];
            ++begin;
            --end;
        }

    }

    private static void test(int[] nums, int k) {

        int len = nums.length;

        int[] resultArr = new int[len];

        for (int i = 0; i < len; i++) {
            int newIndex = (i + k) % len;
            resultArr[newIndex] = nums[i];
        }
        System.arraycopy(nums, 0, resultArr, 0, len);
        String result = Arrays.toString(nums);
        System.out.println("result = " + result);

    }

}
