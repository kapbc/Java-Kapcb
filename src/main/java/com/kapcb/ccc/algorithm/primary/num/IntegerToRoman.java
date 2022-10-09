package com.kapcb.ccc.algorithm.primary.num;

/**
 * <a>Title: IntegerToRoman </a>
 * <a>Author: kapcb <a>
 * <a>Description: 整数转罗马数字 <a>
 * <a href="https://leetcode.cn/problems/integer-to-roman/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/27 21:32
 * @since 1.0
 */
public class IntegerToRoman {

    public static void main(String[] args) {

    }

    public static String intToRoman(int num) {

        return null;

    }

    private static String caseNum(int num) {
        String res = "";
        switch (num) {
            case 1:
                res = "I";
                break;
            case 4:
                res = "IV";
                break;
            case 5:
                res = "V";
                break;
            case 10:
                res = "X";
                break;
            case 50:
                res = "L";
                break;
            case 100:
                res = "C";
                break;
            case 500:
                res = "D";
                break;
            case 1000:
                res = "M";
                break;
            default:
                break;
        }
        return res;

    }

}
