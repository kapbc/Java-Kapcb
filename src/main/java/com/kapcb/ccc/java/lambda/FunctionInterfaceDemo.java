package com.kapcb.ccc.java.lambda;

import java.util.function.IntConsumer;

/**
 * <a>Title: FunctionInterfaceDemo </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/1-13:40
 */
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        repeat(10, () -> System.out.println("kapcb nb"));

        countDown(10, element -> System.out.println(9 - element));
    }

    private static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }

    private static void countDown(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}
