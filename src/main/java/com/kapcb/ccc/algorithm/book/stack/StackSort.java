package com.kapcb.ccc.algorithm.book.stack;

import java.util.Stack;

/**
 * <a>Title: StackSort </a>
 * <a>Author: kapcb <a>
 * <a>Description: 使用栈实现另一个栈的排序 <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/26 23:03
 * @since 1.0
 */
public class StackSort {

    private static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();

        while (!stack.empty()) {
            int val = stack.pop();
            while (!help.empty() && help.peek() < val) {
                stack.push(help.pop());
            }
            help.push(val);
        }

        while (!help.empty()) {
            stack.push(help.pop());
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        System.out.println("stack = " + stack);
        sortStackByStack(stack);
        System.out.println("stack = " + stack);
    }

}
