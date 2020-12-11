package com.kapcb.ccc.java.loop;

/**
 * <a>Title: Print </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/18-8:24
 */
public class Print {
    private static final String SPACE = " ";
    private static final String OPERATOR = "*";

    public static void main(String[] args) {
        getPrint(6);
    }

    private static void getPrint(int num) {
        if (num < 0 || num == 0) {
            return;
        }
        String result;
        for (int i = 1; i <= num; i++) {
            result = "" + OPERATOR;
            for (int k = num - i; k >= 0; k--) {
                result = result + SPACE;
            }
            for (int j = 1; j < i * 2; j++) {
                result = result + OPERATOR;
            }
            System.out.println(result);
        }
    }
}
