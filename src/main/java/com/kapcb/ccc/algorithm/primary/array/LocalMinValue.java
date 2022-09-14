package com.kapcb.ccc.algorithm.primary.array;

/**
 * <a>Title: LocalMinValue </a>
 * <a>Author: Kapcb <a>
 * <a>Description: LocalMinValue <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/14 10:09 PM
 * @since 1.0
 */
public class LocalMinValue {

    // 局部最小值:
    // 给定一个无须数组, 任意两个相邻元素互不相等, 请返回数组中的任意一个局部最小值的对应的下标
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 4, 5, 6, 7, 8, 6, 8};
        int i = minValue(nums);
        System.out.println("i = " + i);
    }

    private static int minValue(int[] nums) {

        // 边界条件判断
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;

        // 如果数组中只有一个元素, 当前元素就是局部最小值, 直接返回
        if (n == 1) {
            return 0;
        }

        if (nums[n - 1] < nums[n - 2]) {
            return n - 1;
        }

        int l = 0;
        int r = n - 1;

        while (l < (r - 1)) {

            int mid = l + ((r - l) >> 1);

            // 左 > 我, 我 < 右
            if (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) {
                return mid;
            } else {
                // 1、左 > 我, 我 > 右
                // 2、左 < 我, 我 < 右
                // 3、左 < 我, 我 > 右
                if (nums[mid] > nums[mid - 1]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }

        // l >= r-1
        return nums[l] < nums[r] ? l : r;
    }

}
