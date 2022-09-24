package com.kapcb.ccc.algorithm.primary.array.sort;

import java.util.Arrays;

/**
 * <a>Title: SelectionSort </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SelectionSort <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/14 9:39 PM
 * @since 1.0
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 8, 6, 5, 9, 2, 1, 2, 4, 3};

        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{4, 8, 6, 5, 9, 2, 1, 2, 4, 3};

        sort(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    /**
     * 选择排序:
     * 0 ~ n-1的位置上找到最小值放在0位置
     * 1 ~ n-1的位置上找到最小值放在1位置
     * 2 ~ n-1的位置上找到最小值放在2位置
     *
     * @param arr int[]
     */
    private static void sort(int[] arr) {

        // 边界条件判断
        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length;

        // 在i ~ n-1位置上寻找最小值下标, 替换
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            // 在i+1 ~ n-1位置上寻找最小元素的下标
            for (int j = i + 1; j < n; j++) {
                minValueIndex = arr[j] > arr[minValueIndex] ? minValueIndex : j;
            }

            // 如果i不是最小元素下标
            if (minValueIndex != i) {
                // 交换
                swap(arr, minValueIndex, i);
            }

        }

    }

    /**
     * 选择排序:
     * 0 ~ n-1的位置上找到最小值放在0位置
     * 1 ~ n-1的位置上找到最小值放在1位置
     * 2 ~ n-1的位置上找到最小值放在2位置
     *
     * @param nums int[]
     */
    private static void optimizeSort(int[] nums) {

        // 边界条件判断
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;

        // 在i ~ n-1位置上寻找最小值下标, 替换
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            // 在i+1 ~ n-1位置上寻找最小元素的下标
            for (int j = i + 1; j < n; j++) {
                minValueIndex = nums[minValueIndex] > nums[j] ? j : minValueIndex;
            }
            // 如果i不是最小元素下标
            if (i != minValueIndex) {
                // 交换
                swap(nums, i, minValueIndex);
            }
        }

    }

    /**
     * 交换
     *
     * @param arr int[]
     * @param l   int
     * @param r   int
     */
    private static void swap(int[] arr, int l, int r) {
        if (l != r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
    }

}
