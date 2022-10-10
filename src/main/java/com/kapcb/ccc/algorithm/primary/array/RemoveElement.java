package com.kapcb.ccc.algorithm.primary.array;

/**
 * <a>Title: RemoveElement </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RemoveElement <a>
 * <a href="https://leetcode.cn/problems/remove-element/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/10/10 10:59 PM
 * @since 1.0
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement(nums, 2);
        System.out.println("i = " + i);

        int[] nums1 = new int[]{3, 2, 2, 3};
        int i1 = removeElement(nums1, 3);
        System.out.println("i1 = " + i1);
    }

    private static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (val != nums[i]) {
                nums[j++] = nums[i];
            }
        }

        return j;

    }

}
