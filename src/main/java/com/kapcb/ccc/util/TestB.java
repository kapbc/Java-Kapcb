package com.kapcb.ccc.util;

/**
 * <a>Title: TestB </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/2 9:32
 */
public class TestB {


    public static void main(String[] args) {
        String s = switchEnums("1");
        System.out.println("s = " + s);
    }

    private static String switchEnums(String value) {
        var num = switch (value) {
            case "1", "2" -> "工作";
            case "3" -> "休息1";
            case "4" -> "休息2";
            default -> throw new RuntimeException("aaaa");
        };
        return num;
    }
}
