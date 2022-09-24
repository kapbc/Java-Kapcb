package com.kapcb.ccc.algorithm.primary.array.sort;

import java.util.Arrays;

/**
 * <a>Title: MergeSort </a>
 * <a>Author: Kapcb <a>
 * <a>Description: 归并排序 <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/24 5:17 PM
 * @since 1.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 6, 5, 9, 2, 1, 2, 4, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);

        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        // 第一个数组的指针
        int p1 = l;
        // 第二个数组的指针
        int p2 = m + 1;

        // [l, m] 为第一个数组的下标区间
        // [m+1, r] 为第二个数组的下标区间
        // 在下标都不越界的情况下
        while (p1 <= m && p2 <= r) {
            // 谁小就将谁放在辅助数组的响应下标上
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 下面两个while只会走其中的一个
        // 将剩余的部分直接拷贝到辅助数组的最后面
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 将排序好后的数组拷贝回原array中
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

}
