package com.kapcb.ccc.algorithm.primary.array;

import java.util.Arrays;

/**
 * <a>Title: BubbleSort </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BubbleSort <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/14 9:32 PM
 * @since 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 6, 5, 9, 2, 1, 2, 4, 3};

        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{4, 8, 6, 5, 9, 2, 1, 2, 4, 3};

        optimizeSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 冒泡排序:
     * 0 ~ n-1上, 相邻两元素比较, 前者大于后者则交换,
     * 0 ~ n-2上, 相邻两元素比较, 前者大于后者则交换,
     * 0 ~ n-3上, 相邻两元素比较, 前者大于后者则交换,
     *
     * @param arr int[]
     */
    private static void sort(int[] arr) {

        // 边界条件判断
        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length;

        // 0 ~ n-1 上交换
        // 0 ~ n-2 上执行一次
        // 0 ~ n-3
        // 0 ~ end
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }

            }

        }

    }

    private static void optimizeSort(int[] nums) {

        //边界条件判断
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;

        // 0 ~ n-1 上交换
        // 0 ~ n-2 上执行一次
        // 0 ~ n-3
        // 0 ~ end
        for (int end = n - 1; end >= 0; end--) {
            // 在 0 ~ end 上进行交换
            for (int second = 1; second <= end; second++) {
                if (nums[second - 1] > nums[second]) {
                    swap(nums, second - 1, second);
                }
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
