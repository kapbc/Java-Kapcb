package com.kapcb.ccc.algorithm.leetcode.junior;

import java.util.Arrays;

/**
 * <a>Title: ReverseString </a>
 * <a>Description: ReverseString <a>
 * <a href="https://leetcode.cn/problems/reverse-string/">...</a>
 *
 * @version 1.0
 * @date 2022/8/28 11:17
 * @since 1.0
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        String result = Arrays.toString(s);
        System.out.println("result = " + result);
    }

    public static void reverseString(char[] s) {
        int len = s.length;

        if (len <= 1) {
            return;
        }

        int l = 0;
        int r = len - 1;

        while (l < r) {
            swap(s, l++, r--);
        }

    }

    private static void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }

}
