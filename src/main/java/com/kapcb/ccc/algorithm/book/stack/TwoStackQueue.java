package com.kapcb.ccc.algorithm.book.stack;

import java.util.Stack;

/**
 * <a>Title: TwoStackQueue </a>
 * <a>Author: Kapcb <a>
 * <a>Description: 由两个栈组成的队列 <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/26 22:38
 * @since 1.0
 */
public class TwoStackQueue {

    private Stack<Integer> stackPush;

    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void add(int pushInt) {
        this.stackPush.push(pushInt);
    }

    public int poll() {
        if (this.stackPush.empty() && this.stackPop.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (this.stackPop.empty()) {
            while (!this.stackPush.empty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.pop();
    }

    public int peek() {
        if (this.stackPush.empty() && this.stackPop.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (this.stackPop.empty()) {
            while (!this.stackPush.empty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.peek();
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        for (int i = 0; i < arr.length; i++) {
            twoStackQueue.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(twoStackQueue.poll() + " ,");
        }

        System.out.println();
    }

}
