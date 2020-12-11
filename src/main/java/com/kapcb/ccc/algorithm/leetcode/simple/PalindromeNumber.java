package com.kapcb.ccc.algorithm.leetcode.simple;

/**
 * <a>Title: PalindromeNumber </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/17 - 21:54
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * link: https://leetcode-cn.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int num = 121;
        int testNum = -121;
        int testNum1 = 10;
        boolean palindromeNumberNotRecommended = getPalindromeNumberNotRecommended(testNum1);
        System.out.println(palindromeNumberNotRecommended);

        boolean palindromeNumber = getPalindromeNumber(testNum1);
        System.out.println(palindromeNumber);
    }

    /**
     * 不使用转换字符串，当反转后的数组大于等于当前数字时，就证明已经反转过半了
     *
     * @param num int
     * @return boolean
     */
    private static boolean getPalindromeNumber(int num) {
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }
        int halfNum = 0;
        while (num > halfNum) {
            halfNum = num % 10 + halfNum * 10;
            num /= 10;
        }
        return halfNum == num || halfNum / 10 == num;
    }

    /**
     * 转换字符串后反转判断是否相等
     *
     * @param num num
     * @return boolean
     */
    private static boolean getPalindromeNumberNotRecommended(int num) {
        if (num >= 0) {
            String s = new StringBuilder(String.valueOf(num)).reverse().toString();
            if (s.equals(String.valueOf(num))) {
                return true;
            }
        }
        return false;
    }
}
