package com.kapcb.ccc.algorithm.leetcode.simple;


/**
 * <a>Title: ImplementStr </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/30-10:18
 * <p>
 * 给定一个hystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回-1。
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 当 needle 是空字符串时，返回0
 * <p>
 * link: https://leetcode-cn.com/problems/implement-strstr/
 */
public class ImplementStr {

    public static void main(String[] args) {
        String hayStack = "hello";
        String needle = "l";
        int i = hayStack.indexOf(needle);
        System.out.println("i = " + i);

    }

    /**
     * 如果为空串,则直接返回 0
     *
     * @param hayStack String
     * @param needle   String
     * @return int
     */
    private static int indexOf(String hayStack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        char[] chars = hayStack.toCharArray();
        char[] charArray = needle.toCharArray();
        boolean flag = true;
        int result = -1;
        loop:
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == charArray[0]) {
                for (int j = 0; j < charArray.length; j++) {
                    if (charArray[j] != chars[i + j]) {
                        flag = false;
                        break loop;
                    }
                }
            }
            if (flag) {
                result = i;
            }
        }
        return result;
    }
}
