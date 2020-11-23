package com.kapcb.ccc.leetcode;

import java.util.Arrays;

/**
 * <a>Title: FirstAndLastIndexInArray </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/23 - 20:45
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * link: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstAndLastIndexInArray {

    public static void main(String[] args) {
        int[] array = {5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(array, 11);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 双指针，左右同时查找
     *
     * @param array  int[]
     * @param target int
     * @return int[]
     */
    private static int[] searchRange(int[] array, int target) {
        int[] result = new int[]{-1, -1};
        if (array[array.length - 1] < target || array[0] > target) {
            return result;
        }
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while (firstIndex <= lastIndex) {
            while (array[firstIndex] <= target) {
                if (array[firstIndex] == target) {
                    result[0] = firstIndex;
                    break;
                }
                firstIndex++;
            }
            while (array[lastIndex] >= target) {
                if (array[lastIndex] == target) {
                    result[1] = lastIndex;
                    break;
                }
                lastIndex--;
            }
            firstIndex++;
            lastIndex--;
        }
        return result;
    }
}
