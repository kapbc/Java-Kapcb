package com.kapcb.ccc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname TwoSum
 * @date 2020/11/4 15:39
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * link: https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        List twoSum = getTwoSum(nums, 18);
        System.out.println(twoSum);
    }

    private static List getTwoSum(int[] array, int target) {
        Arrays.sort(array);
        List<Integer> indexArray = new ArrayList<>();
        loop:
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    if (indexArray.contains(i) && indexArray.contains(j)) {
                        continue loop;
                    } else {
                        indexArray.add(i);
                        indexArray.add(j);
                        continue loop;
                    }
                }
            }
        }
        return indexArray;
    }
}
