package com.kapcb.ccc.algorithm.primary.num;

/**
 * <a>Title: ReverseInteger </a>
 * <a>Author: Kapcb <a>
 * <a>Description: 整数反转 <a>
 * <a href="https://leetcode.cn/problems/reverse-integer/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/25 1:01 PM
 * @since 1.0
 */
public class ReverseInteger {

    public static void main(String[] args) {

        int reverse = reverse(-1200);
        System.out.println("reverse = " + reverse);

    }

    private static int reverse(int x) {

        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }

        return (int) n == n ? (int) n : 0;
    }

}
