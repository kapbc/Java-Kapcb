package com.kapcb.ccc.algorithm.leetcode;

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
        int search = search(array, 7);
        System.out.println(search);

    }

    private static int search(int[] array, int target) {
        int result = -1;
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
            boolean inArrayOne = false;
            while (i < len) {
                if (array[i] == target) {
                    result = i;
                    inArrayOne = true;
                    break;
                }
                array1[i] = array[i];
                i++;
            }
            boolean inArrayTwo = false;
            while (j < len2) {
                if (array[i + j] == target) {
                    result = i + j;
                    inArrayTwo = true;
                    break;
                }
                array2[j] = array[i + j];
                j++;
            }
        }
        return result;
    }
}
