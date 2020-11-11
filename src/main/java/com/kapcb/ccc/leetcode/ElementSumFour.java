package com.kapcb.ccc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <a>Title:ElementSumFour</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/11/11 21:19
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 答案中不可以包含重复的四元组。
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * link: https://leetcode-cn.com/problems/4sum/
 */
public class ElementSumFour {

    private static final Logger logger = Logger.getLogger(String.valueOf(ElementSumFour.class), "logmessage_en");

    public static void main(String[] args) {
        int[] array = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> fourElementSum = getFourElementSum(array, 0);
        System.out.println(fourElementSum);

    }

    /**
     * 双层循环双指针，先固定两个数
     * 去重，找到后面一个与当前相同直接跳过
     *
     * @param array  int[]
     * @param target int
     * @return List<List < Integer>>
     */
    private static List<List<Integer>> getFourElementSum(int[] array, int target) {
        if (array == null || array.length < 4) {
            logger.log(Level.WARNING, "leetcode.error.message");
            return null;
        }
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        int len = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            if ((target >= 0 && array[len - 1] < 0) || (target <= 0 && array[0] > 0)) {
                break;
            }
            for (int j = i + 1; j < array.length; j++) {
                if (i > 0 && (array[j] == array[j - 1])) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = array[i] + array[j] + array[left] + array[right];
                    if (sum == target) {
                        result.add(Arrays.asList(array[i], array[j], array[left], array[right]));
                        while (left < right && array[j] == array[j + 1]) {
                            left++;
                        }
                        while (left < right && array[right] == array[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
