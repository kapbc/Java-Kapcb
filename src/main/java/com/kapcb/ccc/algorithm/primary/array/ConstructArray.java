package com.kapcb.ccc.algorithm.primary.array;

import java.util.Arrays;

/**
 * <a>Title: ConstructArray </a>
 * <a>Description: ConstructArray <a>
 *
 * @version 1.0
 * @date 2022/9/10 0:18
 * @since 1.0
 */
public class ConstructArray {

    /**
     * 阿里面试:
     * 输入一个int类型整数n，构造一个长度为n的arr数组返回
     * 要求: 对于任意的i < k < j, 都满足arr[i] + arr[j] != arr[k] * 2
     *
     * @param args {@link String[]}
     */
    public static void main(String[] args) {
        System.out.println("Test Begin");
        for (int i = 0; i < 100; i++) {
            int[] arr = makeArray(i);
            if (!isValid(arr)) {
                System.out.println("arr is not required! arr : " + Arrays.toString(arr));
            }
        }
        System.out.println("Test End");
    }

    private static int[] makeArray(int size) {

        if (size <= 1) {
            // 种子
            return new int[]{1};
        }

        // 数组长度的一半，向上取整
        int half = (size + 1) >> 1;

        // 递归
        int[] seed = makeArray(half);

        int[] res = new int[size];

        int index = 0;
        // 数组左边都是奇数
        for (; index < half; index++) {
            res[index] = seed[index] * 2 + 1;
        }

        // 数组右边都是偶数
        for (int i = 0; index < size; index++, i++) {
            res[index] = seed[i] * 2;
        }

        return res;

    }

    /**
     * 暴力验证函数
     *
     * @param arr {@link int[]}
     * @return boolean
     */
    private static boolean isValid(int[] arr) {
        if (arr == null) {
            return false;
        }

        int n = arr.length;

        if (n <= 1) {
            return true;
        }

        // 在 0 到 n-1 上每个数字都验证
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                for (int j = k + 1; j < n; j++) {
                    // 任意一个不符合条件返回 false
                    if (arr[i] + arr[j] == arr[k] * 2) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
