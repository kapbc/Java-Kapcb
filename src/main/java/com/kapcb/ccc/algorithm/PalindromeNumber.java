package com.kapcb.ccc.algorithm;

import java.util.Scanner;

/**
 * <a>Title: PalindromeNumber </a>
 * <a>Author: kapcb <a>
 * <a>Description：回文数字<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-16:32
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println("请输入一个范围在: [" + Integer.MIN_VALUE + ", " + Integer.MAX_VALUE + " ] 之间的正整数!");
            int element = scanner.nextInt();
            if (judgeThePalindromeNumber(element)) {
                System.out.println("是回文");
                return;
            }
            System.out.println("不是回文");
        }
    }

    /**
     * 获取回文数字
     *
     * @param num int
     * @return boolean
     */
    private static boolean judgeThePalindromeNumber(int num) {
        if (num < 0) {
            return false;
        }
        int reverse = 0;
        while (num > reverse) {
            reverse = num % 10 + reverse * 10;
            num = num / 10;
        }
        return num == reverse || num == reverse / 10;
    }
}
