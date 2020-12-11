package com.kapcb.ccc.datastructure.data.sort;

import java.util.Arrays;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname InsertSort
 * @date 2020/10/30 16:06
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] array = {15, 11, 7, 56, 24, 59, 8, 20, 9, 8, 4, 12, 10, 44, 83, 28, 5, 1, 0, 36};

        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }
}
