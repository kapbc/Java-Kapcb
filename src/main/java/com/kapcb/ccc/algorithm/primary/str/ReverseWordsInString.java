package com.kapcb.ccc.algorithm.primary.str;

/**
 * <a>Title: ReverseWordsInAString </a>
 * <a>Description: ReverseWordsInAString <a>
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string-iii/">...</a>
 *
 * @version 1.0
 * @date 2022/8/28 11:33
 * @since 1.0
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String result = reverseWords(s);
        System.out.println("result = " + result);
    }

    private static String reverseWords(String s) {
        String[] sArr = s.split(" ");

        int wordNum = sArr.length;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < wordNum; i++) {
            char[] chars = sArr[i].toCharArray();

            reverseString(chars);

            sb.append(chars).append(" ");

        }
        return sb.toString().trim();
    }

    private static void reverseString(char[] chars) {
        int len = chars.length;

        int l = 0;
        int r = len - 1;

        while (l < r) {
            swap(chars, l++, r--);
        }
    }

    private static void swap(char[] chars, int l, int r) {
        char temp = chars[r];
        chars[r] = chars[l];
        chars[l] = temp;
    }

}
