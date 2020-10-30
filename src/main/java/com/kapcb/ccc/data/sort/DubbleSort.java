package com.kapcb.ccc.data.sort;

import java.util.Arrays;

public class DubbleSort {


    public static void main(String[] args) {
        int[] array = {15, 11, 7, 56, 24, 59, 8, 20, 9, 8, 4, 12, 10, 44, 83, 28, 5, 1, 0, 36};
        dubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void dubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                boolean flag = false;
                if (array[j] > array[j + 1]) {
                    flag = true;
                }

                if (flag) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
