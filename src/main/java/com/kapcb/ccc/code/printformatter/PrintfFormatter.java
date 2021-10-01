package com.kapcb.ccc.code.printformatter;

/**
 * <a>Title: PrintfFormatter </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/19 - 12:13
 */
public class PrintfFormatter {

    public static void main(String[] args) {
        Integer testOne = 17;
        Float testTwo = 224.0F;
        System.out.printf("Row 1: [%d ,%f]\n", testOne, testTwo);
    }
}
