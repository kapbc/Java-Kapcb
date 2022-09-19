package com.kapcb.ccc.algorithm.primary.str;

import java.util.Arrays;

/**
 * <a>Title: ReverseString </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ReverseString <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/19 9:52 PM
 * @since 1.0
 */
public class ReverseString {

    public static void main(String[] args) {
        String str = "abcd";
        String solve = solve(str);
        System.out.println("solve = " + solve);
    }

    private static String solve(String str) {
        // write code here

        if (str == null || str.length() < 2) {
            return str;
        }

        char[] strArray = str.toCharArray();

        int l = 0;
        int r = strArray.length - 1;

        while (l < r) {
            swap(strArray, l++, r--);
        }

        return String.valueOf(strArray);

    }

    private static void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }

}
