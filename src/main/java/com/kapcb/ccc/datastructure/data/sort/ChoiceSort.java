package com.kapcb.ccc.datastructure.data.sort;

import java.util.Arrays;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname ChoiceSort
 * @date 2020/10/30 15:36
 */
public class ChoiceSort {

    public static void main(String[] args) {
        int[] array = {15, 11, 7, 56, 24, 59, 8, 20, 9, 8, 4, 12, 10, 44, 83, 28, 5, 1, 0, 36};
        choiceSort(array);
        System.out.println(Arrays.toString(array));
    }


    private static void choiceSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int max = 0;
            for (int j = 0; j < array.length - i; j++) {
                if (array[max] < array[j]) {
                    max = j;
                }
            }
            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[max];
            array[max] = temp;
        }
    }
}
