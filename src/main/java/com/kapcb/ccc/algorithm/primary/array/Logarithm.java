package com.kapcb.ccc.algorithm.logarithm;

import java.util.Arrays;

/**
 * <a>Title: Logarithm </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Logarithm <a>
 * <p>
 * 对数器
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/20 20:57
 * @since 1.0
 */
public class Logarithm {

    private Logarithm() {
    }

    /**
     * Math.random() -> [0, 1) 所有的小数, 等概率返回一个
     * Math.random() * N -> [0, n) 所有的小数, 等概率返回一个
     * (int)(Math.random() * N) -> [0, N-1] 所有的整数, 等概率返回一个
     *
     * @param maxSize  int
     * @param maxValue int
     * @return int[]
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 数组长度随机
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            // 两个随机值相减
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 数组拷贝
     *
     * @param arr int[]
     * @return int[]
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * print array
     *
     * @param arr int[]
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * check two array is equal
     *
     * @param arrOne int[]
     * @param arrTwo int[]
     * @return boolean
     */
    public static boolean isEqual(int[] arrOne, int[] arrTwo) {
        boolean arrOneNull = arrOne == null && arrTwo != null;
        boolean arrTwoNull = arrOne != null && arrTwo == null;
        if (arrOneNull || arrTwoNull) {
            return false;
        }
        if (arrOne == arrTwo) {
            return true;
        }
        if (arrOne.length != arrTwo.length) {
            return false;
        }
        for (int i = 0; i < arrOne.length; i++) {
            if (arrOne[i] != arrTwo[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * array comparator
     *
     * @param arr int[]
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

}
