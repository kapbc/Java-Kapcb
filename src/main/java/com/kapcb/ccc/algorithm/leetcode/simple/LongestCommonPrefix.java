package com.kapcb.ccc.algorithm.leetcode.simple;

import java.util.Arrays;
import java.util.List;

/**
 * <a>Title: LongestCommonPrefix </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11 - 22:59
 * <p>
 * link: https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("flower", "flow", "flight");
        List<String> listTwo = Arrays.asList("dog", "racecar", "car");
        String s = longestCommonPrefix(list);
        String two = longestCommonPrefix(listTwo);
        System.out.println(s);
        System.out.println(two);
    }

    /**
     * 枚举
     *
     * @param list List<String>
     * @return String
     */
    private static String longestCommonPrefix(List<String> list) {
        int length = list.size();
        String temp = list.get(0);
        for (int i = 1; i < length; i++) {
            int index = 0;
            while (index < length && index < list.get(i).length()) {
                if (temp.charAt(index) != list.get(i).charAt(index)) {
                    break;
                }
                index++;
            }
            temp = temp.substring(0, index);
            if ("".equals(temp)) {
                return "";
            }
        }
        return temp;
    }
}
