package com.kapcb.ccc.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * <a>Title: SearchInRotatedSortedArray </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/25 - 22:21
 * <p>
 * link: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 4, 5, 6, 7};
        search(array, 1);

    }

    private static int search(int[] array, int target) {
        if (target >= array[0] && target <= array[array.length - 1]) {
            Random random = new Random();
            int len = 0;
            do {
                len = random.nextInt(array.length);
            } while (len == 0);
            int len2 = array.length - len;
            int[] array1 = new int[len];
            int[] array2 = new int[len2];
            int i = 0;
            int j = 0;
            while (i < len) {
                array1[i] = array[i];
                i++;
            }
            while (j < len2) {
                array2[j] = array[i + j];
                j++;
            }
        }
        int result = -1;

        return result;
    }
}
