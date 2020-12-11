package com.kapcb.ccc.algorithm.thinkinjava;

import java.util.LinkedList;
import java.util.List;

/**
 * <a>Title:Fibonacci</a>
 * <a>Author：ccc<a>
 * <a>Description：斐波拉契数列<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/15 22:30
 */
public class Fibonacci {
    public static void main(String[] args) {
        List fibonacciSequence = getFibonacciSequence(4);
        System.out.println("fibonacciSequence = " + fibonacciSequence);
    }

    private static List getFibonacciSequence(int target) {
        if (target <= 0) {
            System.out.println("输入参数有误");
            return null;
        }

        List<Integer> elementList = new LinkedList<>();
        elementList.add(1);
        if (target >= 2) {
            elementList.add(1);
            if (target > 2) {
                for (int i = 0; i < target - 2; i++) {
                    elementList.add((elementList.get(i)) + elementList.get(i + 1));
                }
            }
        }
        return elementList;
    }
}
