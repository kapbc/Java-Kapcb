package com.kapcb.ccc.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * <a>Title: FindFirstAndLastIndexInSortedArray </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/1-17:10
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * link: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastIndexInSortedArray {

    public static void main(String[] args) {
        int[] array = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(array, 7);
        System.out.println(Arrays.toString(result));
    }

    private static int[] searchRange(int[] array, int target) {
        int len = array.length;
        int leftIndex = 0;
        int rightIndex = len - 1;
        int[] result = new int[]{-1, -1};
        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
            if (array[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            }
            if (array[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            }
            if (array[middleIndex] == target) {
                int temp = middleIndex;
                if (array[temp] != target) {
                    result[0] = temp + 1;
                } else {
                    temp--;
                }
                if (array[middleIndex] != target) {
                    result[1] = middleIndex - 1;
                } else {
                    middleIndex++;
                }

            }
            leftIndex++;
            rightIndex--;
        }
        return result;
    }
}
