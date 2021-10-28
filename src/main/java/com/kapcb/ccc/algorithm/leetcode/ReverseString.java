package com.kapcb.ccc.algorithm.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname ReverseString
 * @date 2020/11/11 15:17
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * link： https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseString {

    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in);) {
//            String next = "";
//            while (true) {
//                next = scanner.next();
//                char[] arrayStr = next.toCharArray();
//                char[] reverseString = getReverseString(arrayStr);
//                System.out.println(Arrays.toString(reverseString));
//            }
//        }

        String id = "mike_nb&12344341213231&mike_nb";
        System.out.println("id = " + id);
        String s = reverseString(id);
        System.out.println("s = " + s);
        String s1 = reverseString(s);
        System.out.println("s1 = " + s1);
        boolean equals = id.equals(s1);
        System.out.println("equals = " + equals);
    }

    /**
     * 双指针交换法
     *
     * @param arrayStr char[]
     * @return char[]
     */
    private static char[] getReverseString(char[] arrayStr) {
        int right = arrayStr.length - 1;
        for (int left = 0; left < right; left++, right--) {
            char temp = arrayStr[left];
            if (temp == arrayStr[right]) {
                continue;
            } else {
                arrayStr[left] = arrayStr[right];
                arrayStr[right] = temp;
            }
        }
        return arrayStr;
    }

    private static String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        for (int left = 0, right = array.length - 1; left < right; left++, right--) {
            swap(array, left, right);
        }
        return new String(array);
    }

    private static void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
