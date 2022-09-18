package com.kapcb.ccc.algorithm.leetcode.junior;

/**
 * <a>Title: RemoveDuplicates </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RemoveDuplicates <a>
 * <a href="https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/8/21 8:31 PM
 * @since 1.0
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int solutionByDoublePoint = solutionByDoublePoint(nums);
        System.out.println("solutionByDoublePoint = " + solutionByDoublePoint);
        int solutionByDuplicateCount = solutionByDuplicateCount(nums);
        System.out.println("solutionByDuplicateCount = " + solutionByDuplicateCount);
    }

    /**
     * 双指针
     *
     * @param nums int[]
     * @return array's length after remove duplicate
     */
    private static int solutionByDoublePoint(int[] nums) {

        // 边界条件判断
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 左指针
        int left = 0;

        // 右指针， 原则左指针不动右指针动
        for (int right = 1; right < nums.length; right++) {
            // 如果左指针和右指针指向的值一样，则说明有重复
            // 这个时候左指针不动，右指针继续向右移动。
            // 当左指针与右指针指向的值不一样，就把右指针指向的值挪到左指针指向的值的后面，同时左指针后移一位
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }

        return ++left;

    }

    /**
     * 双指针
     *
     * @param nums int[]
     * @return array's length after remove duplicate
     */
    private static int solutionByDuplicateCount(int[] nums) {

        // 边界条件判断
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 重复元素个数
        int count = 0;
        // 数组长度
        int length = nums.length;
        for (int right = 1; right < length; right++) {

            if (nums[right] == nums[right - 1]) {
                // 如果相邻的两个元素重复，则重复元素个数+1
                count++;
            } else {
                // 如果没有重复，则将后面的元素往前移动
                nums[right - count] = nums[right];
            }

        }

        // 原数组的长度减去重复元素的个数
        return length - count;

    }


}
