package com.kapcb.ccc.algorithm.primary.array.sort;

import java.util.Arrays;

/**
 * <a>Title: InsertionSort </a>
 * <a>Author: Kapcb <a>
 * <a>Description: InsertionSort <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/14 9:49 PM
 * @since 1.0
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 8, 6, 5, 9, 2, 1, 2, 4, 3};

        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{4, 8, 6, 5, 9, 2, 1, 2, 4, 3};

        sort1(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{4, 8, 6, 5, 9, 2, 1, 2, 4, 3};
        optimizeSort(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    private static void sort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 插入排序:
     * 保证 0 ~ 0上有序
     * 保证 0 ~ 1上有序
     * 保证 0 ~ 2上有序
     * 保证 0 ~ 3上有序
     * 保证 0 ~ end上有序
     * 扑克牌
     *
     * @param nums int[]
     */
    private static void sort1(int[] nums) {

        // 边界条件判断
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;

        // 0 ~ 0 上有序, 已经完成, 天然有序
        // 0 ~ 1 上有序
        // 0 ~ 2 上有序
        // 0 ~ 3 上有序
        for (int end = 1; end < n; end++) {
            // 新元素一定是在end位置的
            int newNumIndex = end;
            // 所以看end - 1上是否有元素, 并且end-1 > end则交换
            while (newNumIndex - 1 >= 0 && nums[newNumIndex - 1] > nums[newNumIndex]) {
                swap(nums, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }

    }

    private static void optimizeSort(int[] nums) {

        // 边界条件判断
        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;

        for (int end = 1; end < n; end++) {
            // pre 是当前元素的前一位
            for (int pre = end - 1; pre >= 0 && nums[pre] > nums[pre + 1]; pre--) {
                swap(nums, pre, pre + 1);
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
