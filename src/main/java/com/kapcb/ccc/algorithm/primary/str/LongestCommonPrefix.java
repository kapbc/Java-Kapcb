package com.kapcb.ccc.algorithm.primary.str;

/**
 * <a>Title: LongestCommonPrefix </a>
 * <a>Author: Kapcb <a>
 * <a>Description: LongestCommonPrefix <a>
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/10/10 10:45 PM
 * @since 1.0
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] str1 = new String[]{"flower", "flow", "flight"};
        String res1 = longestCommonPrefix(str1);
        System.out.println("res1 = " + res1);

        String[] str2 = new String[]{"dog", "racecar", "car"};
        String res2 = longestCommonPrefix(str2);
        System.out.println("res2 = " + res2);

    }

    private static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        // 公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];

        for (String str : strs) {
            while (!str.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                // 公共前缀不匹配就让它变短
                s = s.substring(0, s.length() - 1);
            }
        }

        return s;
    }

}
