package com.kapcb.ccc.algorithm.book;

import java.util.Stack;

/**
 * <a>Title: MyStack </a>
 * <a>Author: Kapcb <a>
 * <a>Description: 设计一个有getMin功能的栈 <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/26 22:20
 * @since 1.0
 */
public class MyStack {

    private Stack<Integer> stackMin;

    private Stack<Integer> stackData;

    public MyStack() {
        stackMin = new Stack<>();
        stackData = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        int val = stackData.pop();
        if (val == this.getMin()) {
            this.stackMin.pop();
        }
        return val;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return this.stackMin.peek();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "stackMin=" + stackMin +
                ", stackData=" + stackData +
                '}';
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        MyStack myStack = new MyStack();
        for (int i = 0; i < arr.length; i++) {
            myStack.push(arr[i]);
        }

        System.out.println("myStack = " + myStack);

        int min = myStack.getMin();
        System.out.println("min = " + min);
    }

}
