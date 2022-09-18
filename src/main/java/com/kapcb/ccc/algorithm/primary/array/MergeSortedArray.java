package com.kapcb.ccc.algorithm.primary.array;

import java.util.Arrays;

/**
 * <a>Title: MergeSortedArray </a>
 * <a>Description: MergeSortedArray <a>
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/8/31 21:29
 * @since 1.0
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};

        merge(nums1, 3, nums2, 3);
        String result = Arrays.toString(nums1);
        System.out.println("result = " + result);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;

        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[--i] = nums1[--m];
            } else {
                nums1[--i] = nums2[--n];
            }
        }

    }

    public static void mergeArray(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int len = m + n;

        for (int i = len - 1; i >= 0 && n > 0; i--) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[--m];
            } else {
                nums1[i] = nums2[--n];
            }
        }

    }

}
