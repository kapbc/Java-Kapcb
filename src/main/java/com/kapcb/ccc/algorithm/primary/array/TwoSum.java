package com.kapcb.ccc.algorithm.leetcode.junior;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: tesst </a>
 * <a>Description: tesst <a>
 * <a href="https://leetcode.cn/problems/two-sum/">...</a>
 *
 * @version 1.0
 * @date 2022/8/28 13:29
 * @since 1.0
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        int[] ints = foundTwoSum(a, 9);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] foundTwoSum(int[] nums, int target) {

        int len = nums.length;

        // 边界条件判断
        if (len <= 1) {
            return new int[0];
        }

        // HashMap的key存放元素, value存放元素对应的数组下标, HashMap的查找是O(logN)
        Map<Integer, Integer> indexParamMap = new HashMap<>(len << 2);

        for (int i = 0; i < len; i++) {
            // 使用减法计算出林一个元素
            int el = target - nums[i];
            // 判断另一个元素在HashMap中是否存在, 如果存在, 取出元素下标返回
            if (indexParamMap.containsKey(el)) {
                return new int[]{i, indexParamMap.get(el)};
            }
            // 将元素与对应的数组下标存放在HashMap中
            indexParamMap.put(nums[i], i);
        }

        return new int[0];

    }

}
