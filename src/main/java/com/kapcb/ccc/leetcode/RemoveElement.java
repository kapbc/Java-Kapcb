package com.kapcb.ccc.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * <a>Title: RemoveElement </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/2-9:23
 * <p>
 * link: https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] testArrayOne = {3, 2, 2, 3};
        int targetOne = 3;
        int[] testArrayTwo = {0, 1, 2, 2, 3, 0, 4, 2};
        int targetTwo = 2;
        int result = removeElement(testArrayOne, targetOne);
        System.out.println("result = " + result);
        int i = removeElement(testArrayTwo, targetTwo);
        System.out.println("i = " + i);
    }

    private static int

    /**
     * 将目标元素移动至数组最后
     *
     * @param array  int[]
     * @param target int
     * @return int
     */
    private static int removeElement(int[] array, int target) {
        int len = array.length;
        int result = 0;
        int index = 0;
        for (int j = 0; j < len; j++) {
            index = j;
            while (index < len && array[j] == target) {
                int temp = 0;
                if (array[index] != target) {
                    result = j;
                    temp = array[j];
                    array[j] = array[index];
                    array[index] = temp;
                    break;
                }
                index++;
            }
        }
        System.out.println(Arrays.toString(array));
        return result + 1;
    }
}
