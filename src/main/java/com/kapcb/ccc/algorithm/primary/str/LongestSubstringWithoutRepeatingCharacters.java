package com.kapcb.ccc.algorithm.primary.str;

/**
 * <a>Title: LongestSubstringWithoutRepeatingCharacters </a>
 * <a>Description: 无重复字符的最长字串 <a>
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/8/30 9:31
 * @since 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }

    /**
     * 滑动窗口
     *
     * @param s String
     * @return int
     */
    private static int lengthOfLongestSubstring(String s) {

        // 边界条件判断
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // 无需全量初始化数组
        int[] last = new int[128];

        int n = s.length();

        // 无重复字串的最大长度
        int max = 0;
        // 窗口开始的位置
        int start = 0;

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            // last[index] + 1：因为last[index]代表当前字符上一次出现位置的，无重复字符字串不能出现相同的字符所以要+1取下一个
            // start：代表滑动窗口开始的位置，所以必须要要看start与last[index] + 1谁大，保证区间内不包含重复字符
            start = Math.max(start, last[index] + 1);
            max = Math.max(max, i - start + 1);
            last[index] = i;
        }

        return max;

    }

}
