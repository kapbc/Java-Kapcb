package com.kapcb.ccc.algorithm.primary.str;

/**
 * <a>Title: LongestPalindromicSubstring </a>
 * <a>Author: Kapcb <a>
 * <a>Description: 最长回文字串 <a>
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/24 3:07 PM
 * @since 1.0
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "ccc";
        String s1 = longestPalindrome(s);
        System.out.println("s1 = " + s1);
    }

    private static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[n][n];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        // 递推开始
        // 先枚举子串长度
        for (int l = 2; l <= n; l++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < n; i++) {
                // 由 l 和 i 可以确定右边界，即 j - i + 1 = l 得
                int j = l + i - 1;

                // 如果右边界越界，就可以退出当前循环
                if (j >= n) {
                    break;
                }

                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;

                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][l] == true 成立，就表示子串 s[i..l] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

}
