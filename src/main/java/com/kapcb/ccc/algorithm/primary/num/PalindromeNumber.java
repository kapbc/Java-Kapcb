package com.kapcb.ccc.algorithm.primary.num;

/**
 * <a>Title: PalindromeNumber </a>
 * <a>Author: Kapcb <a>
 * <a>Description: 回文数 <a>
 * <a href="https://leetcode.cn/problems/palindrome-number/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/26 21:59
 * @since 1.0
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(1221));

        System.out.println(isPalindrome1(-121));
        System.out.println(isPalindrome1(1221));
        System.out.println(isPalindrome1(120));
    }

    /**
     * 反转数字
     *
     * @param x int
     * @return boolean
     */
    private static boolean isPalindrome(int x) {

        // 如果x小于0或者x个位数为0, 则一定不是回文数
        if (x < 0) {
            return false;
        }

        int t = x;
        int r = 0;
        // 反转数字
        while (t != 0) {
            r = r * 10 + t % 10;
            t /= 10;
        }

        // 将反转后的数字与之前的数字对比
        return r == x;
    }

    private static boolean isPalindrome1(int x) {
        // 如果x小于0或者x个位数为0, 则一定不是回文数。0除外
        if (x < 0 || ((x % 10 == 0) && (x != 0))) {
            return false;
        }

        // 反转一半数字
        int r = 0;

        // x每次除10, r每次乘以10, 当r>x的时候一定过了这个数字的一半
        while (x > r) {
            r = r * 10 + x % 10;
            x /= 10;
        }

        // 数字为偶数个刚好为重点 || 数字为奇数个r会多一位中点
        return x == r || x == r / 10;
    }

}
