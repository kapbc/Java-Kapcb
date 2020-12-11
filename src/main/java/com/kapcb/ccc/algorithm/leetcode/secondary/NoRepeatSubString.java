package com.kapcb.ccc.algorithm.leetcode.secondary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname NoRepeatSubString
 * @date 2020/11/9 13:50
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * link: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class NoRepeatSubString {

    public static void main(String[] args) {
        String a = "abcabcbb";
        String b = "bbbbb";
        String c = "pwwkew";
        int noRepeatSubString = getNoRepeatSubString(c);
        System.out.println("noRepeatSubString = " + noRepeatSubString);
    }

    private static int getNoRepeatSubString(String element) {
        int len = element.length();
        int count = 0;
        Map<Character, Integer> map = new HashMap<>(4);
        for (int end = 0, start = 0; end < len; end++) {
            char alpha = element.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            count = Math.max(count, end - start + 1);
            map.put(alpha, end + 1);
        }
        return count;
    }
}
