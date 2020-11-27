package com.kapcb.ccc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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
 */
public class RomanToInt {

    private static final Logger logger = Logger.getLogger(String.valueOf(RomanToInt.class), "logmessage_en");

    public static void main(String[] args) {
        String roman = "XXVII";
        String roman2 = "IV";
        String roman3 = "IX";
        String test = "MCMXCIV";
        int i = romanToInt(roman);
        int i2 = romanToInt(roman2);
        int i3 = romanToInt(roman3);
        int i4 = romanToInt(test);
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
    }

    private static int romanToInt(String roman) {
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
        System.out.println(elementList);
        int size = elementList.size();
        int result = 0;
        int operation = 4000;
        for (int i = 0; i < size; i++) {
            operation = operation >= elementList.get(i) ? elementList.get(i) : -elementList.get(i);
            result = result + operation;
        }
        return result > 0 ? result : -result;
    }
}
