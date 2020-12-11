package com.kapcb.ccc.algorithm.leetcode;

/**
 * <a>Title: SearchInsert </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/27-15:42
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * link: https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 7};
        System.out.println(searchInsert(array, 3));
    }

    private static int searchInsert(int[] array, int target) {
        int len = array.length;
        int leftIndex = 0;
        int rightIndex = len - 1;
        if (target > array[rightIndex]) {
            return len;
        }
        if (target < array[leftIndex]) {
            return 0;
        }
        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
            if (target >= array[middleIndex]) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return leftIndex;
    }
}
