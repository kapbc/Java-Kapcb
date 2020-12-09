package com.kapcb.ccc.leetcode;

import com.kapcb.ccc.util.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * <a>Title: RomanToInt </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/27-16:22
 * <p>
 * link: https://leetcode-cn.com/problems/roman-to-integer/
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 */
public class RomanToInt {

    private static final Logger logger = Logger.getLogger(String.valueOf(RomanToInt.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {
        String roman = "XXVII";
        String roman2 = "IV";
        String roman3 = "IX";
        String roman4 = "MCMXCIV";
        String roman5 = "LVIII";
        int i = romanToInt(roman);
        int i2 = romanToInt(roman2);
        int i3 = romanToInt(roman3);
        int i4 = romanToInt(roman4);
        int i5 = romanToInt(roman5);
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);
    }

    /**
     * 小的数字放在大的数字左边就是减法，否则为加法
     *
     * @param roman String
     * @return int
     */
    private static int romanToInt(String roman) {
        List<Integer> elementList = getElementList(roman);
        int size = elementList.size();
        int result = 0;
        int operation = 0;
        for (int i = 0; i < size - 1; i++) {
            operation = elementList.get(i) >= elementList.get(i + 1) ? elementList.get(i) : -elementList.get(i);
            result = result + operation;
        }
        result = result + elementList.get(size - 1);
        return result;
    }

    /**
     * 罗马文转数字
     *
     * @param roman String
     * @return List<Integer>
     */
    private static List<Integer> getElementList(String roman) {
        String[] split = roman.split("");
        List<Integer> elementList = new ArrayList<>();
        Arrays.stream(split).forEach(x -> {
            switch (x) {
                case "I":
                    elementList.add(1);
                    break;
                case "V":
                    elementList.add(5);
                    break;
                case "X":
                    elementList.add(10);
                    break;
                case "L":
                    elementList.add(50);
                    break;
                case "C":
                    elementList.add(100);
                    break;
                case "D":
                    elementList.add(500);
                    break;
                case "M":
                    elementList.add(1000);
                    break;
                default:
                    logger.warning("leetcode.error.message");
                    break;
            }
        });
        return elementList;
    }
}
