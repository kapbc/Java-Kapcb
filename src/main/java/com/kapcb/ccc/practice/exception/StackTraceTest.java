package com.kapcb.ccc.practice.exception;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname StackTraceTest
 * @date 2020/11/10 13:12
 */
public class StackTraceTest {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println("Pls Entry an number:");
            int i = scanner.nextInt();
            factorial(i);
        }
    }

    private static int factorial(int target) {
        System.out.println("factorial(" + target + ")");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Arrays.stream(stackTrace).forEach(System.out::println);
        int temp;
        if (target <= 1) {
            temp = 1;
        } else {
            temp = target * factorial(target - 1);
        }
        System.out.println("return: " + temp);
        return temp;
    }
}
