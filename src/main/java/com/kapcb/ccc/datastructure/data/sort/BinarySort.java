package com.kapcb.ccc.datastructure.data.sort;

import java.util.Arrays;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname BinarySort
 * @date 2020/10/30 16:38
 */
public class BinarySort {

    public static void main(String[] args) {
        int[] array = {15, 11, 7, 56, 24, 59, 8, 20, 9, 8, 4, 12, 10, 44, 83, 28, 5, 1, 0, 36};
        binarySort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void binarySort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int rightIndex = i - 1;
            int leftIndex = 0;
            while (leftIndex <= rightIndex) {
                int middle = (leftIndex + rightIndex) / 2;
                if (array[middle] > temp) {
                    rightIndex = middle - 1;
                } else {
                    leftIndex = middle + 1;
                }
            }

            for (int j = i - 1; j >= leftIndex; j--) {
                array[j + 1] = array[j];
            }
            array[leftIndex] = temp;
        }
    }
}
