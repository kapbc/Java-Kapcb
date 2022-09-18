package com.kapcb.ccc.algorithm.leetcode.junior;

import java.util.Arrays;

/**
 * <a>Title: MoveZeroes </a>
 * <a>Author: Kapcb <a>
 * <a>Description: MoveZeroes <a>
 * <a href="https://leetcode.cn/problems/move-zeroes/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/8/27 9:05 PM
 * @since 1.0
 */
public class MoveZeroes {

    public static void main(String[] args) {
        // [1,3,12,0,0]
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        moveZeroes1(nums1);
        moveZeroes2(nums2);
    }

    private static void moveZeroes2(int[] nums) {

        int len = nums.length;

        if (len <= 1) {
            return;
        }

        int j = 0;

        for (int i = 0; i < len; i++) {
            // 当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }

        String result = Arrays.toString(nums);
        System.out.println("result = " + result);

    }


    private static void moveZeroes1(int[] nums) {

        int len = nums.length;

        if (len <= 1) {
            return;
        }

        int j = 0;
        // 将所有非0值都复制给nums[j], 同时j+1。执行完之后, 数组的前j位都为非0值。
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        // 从j开始, 往数组尾部补0
        for (int i = j; i < len; i++) {
            nums[i] = 0;
        }

        String result = Arrays.toString(nums);
        System.out.println("result = " + result);

    }

    private static void moveZeroes(int[] nums) {

        int len = nums.length;

        if (len <= 1) {
            return;
        }

        for (int i = 0; i < len; i++) {

            // 如果当前下标元素为0
            if (nums[i] == 0) {
                // 定义一个快指针
                int j = i + 1;

                // 当快指针小于数组长度
                while (j < len) {
                    // 找到第一个不为0的元素
                    if (nums[j] != 0) {
                        // 替换
                        nums[i] = nums[i] ^ nums[j];
                        nums[j] = nums[i] ^ nums[j];
                        nums[i] = nums[i] ^ nums[j];
                        break;
                    }
                    j++;
                }
            }
        }

        String result = Arrays.toString(nums);
        System.out.println("result = " + result);
    }

}
