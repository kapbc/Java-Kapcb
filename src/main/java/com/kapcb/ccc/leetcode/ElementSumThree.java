package com.kapcb.ccc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname ElementSumThree
 * @date 2020/11/11 16:08
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, -1, 2],
 * [-1, 0, 1]
 * ]
 *
 * link: https://leetcode-cn.com/problems/3sum/
 */
public class ElementSumThree {

    private static final Logger logger = Logger.getLogger(String.valueOf(ElementSumThree.class), "logmessage_en");

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        int[] arra = {1, 2};
        List<List<Integer>> threeElementSum = getThreeElementSum(array);
        System.out.println(threeElementSum);
    }

    /**
     * 排序 + 双指针
     *
     * @param array int[]
     * @return List<List < Integer>>
     */
    private static List<List<Integer>> getThreeElementSum(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        if (array.length < 3) {
            logger.log(Level.INFO, "leetcode.error.message");
            return null;
        }
        Arrays.sort(array);
        int len = array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                break;
            } else if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = array[i] + array[left] + array[right];
                if (sum == 0) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    while (left < right && array[left] == array[left + 1]) {
                        left++;
                    }
                    while (left < right && array[right] == array[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }
}
