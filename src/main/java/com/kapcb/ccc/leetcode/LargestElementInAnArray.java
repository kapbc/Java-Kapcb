package com.kapcb.ccc.leetcode;

/**
 * <a>Title: LargestElementInAnArray </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/15 - 21:16
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * link: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class LargestElementInAnArray {

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        int[] testArray = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 2;
        int largestElementInArray = getLargestElementInArray(testArray, 4);
        System.out.println(largestElementInArray);
    }

    /**
     * 排序后返回 length - k 索引的元素
     *
     * @param array int[]
     * @param k     int
     * @return int
     */
    private static int getLargestElementInArray(int[] array, int k) {
        int result = 0;
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        int len = array.length;
        result = array[len - k];
        return result;
    }
}
