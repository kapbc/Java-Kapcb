package com.kapcb.ccc.code.printformatter;

/**
 * <a>Title: SimpleFormatter </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/19 - 12:58
 */
public class SimpleFormatter {

    /**
     * format() 与 printf() 等价
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332543;
        // The old way
        System.out.println("Row 1: [" + x + ", " + y + "]");

        // The new way
        System.out.format("Row 1: [%d, %f]\n", x, y);

        // or
        System.out.printf("Row 1: [%d, %f]\n", x, y);

    }
}
