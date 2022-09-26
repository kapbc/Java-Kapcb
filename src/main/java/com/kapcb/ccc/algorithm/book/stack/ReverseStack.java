package com.kapcb.ccc.algorithm.book.stack;

import java.util.Stack;

/**
 * <a>Title: ReverseStack </a>
 * <a>Author: kapcb <a>
 * <a>Description: 使用递归和栈操作逆序一个栈 <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/26 22:54
 * @since 1.0
 */
public class ReverseStack {

    private static void reverse(Stack<Integer> stack) {

        if (stack.empty()) {
            return;
        }

        int i = getAndRemoveElement(stack);
        reverse(stack);
        stack.push(i);

    }

    private static int getAndRemoveElement(Stack<Integer> stack) {

        int res = stack.pop();

        if (stack.empty()) {
            return res;
        } else {
            int last = getAndRemoveElement(stack);
            stack.push(res);
            return last;
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        System.out.println("stack = " + stack);
        reverse(stack);
        System.out.println("stack = " + stack);
    }

}
