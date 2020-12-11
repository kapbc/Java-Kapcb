package com.kapcb.ccc.algorithm.leetcode;

/**
 * <a>Title: DivideTwoIntegers </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/25-8:21
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * <p>
 * link: https://leetcode-cn.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        int divide = divide(10, 3);
        System.out.println("divide = " + divide);
    }

    /**
     * @param dividend int 被除数
     * @param divisor  int 除数
     * @return int
     */
    private static int divide(int dividend, int divisor) {
        if (divisor > dividend) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        int sign = -1;
        boolean convert = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        if (convert) {
            sign = 1;
        }
        // 转换为负数计算，避免负数转换为正数溢出问题
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;


        int result = deliverTortoise(dividend, divisor);
        return sign == -1 ? -result : result;
    }

    /**
     * 递归
     *
     * @param a int
     * @param b int
     * @return int
     */
    private static int deliverTortoise(int a, int b) {
        if (a > b) {
            return 0;
        }
        int count = 1;
        int operation = b;
        while (operation + operation >= a && operation + operation < 0) {
            operation += operation;
            count += count;
        }

        return count + deliverTortoise(a - operation, b);
    }
}
