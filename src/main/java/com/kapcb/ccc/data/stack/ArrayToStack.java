package com.kapcb.ccc.data.stack;

/**
 * <a>Title:ArrayToStack</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/31 1:10
 */
public class ArrayToStack {

    private int capacity;
    private int index = -1;
    private static int[] stack;

    public ArrayToStack() {
        this.capacity = 10;
        stack = new int[10];
    }

    public ArrayToStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }


    public void push(int element) {
        if (isFull(stack)) {
            System.out.println("栈已满!压栈操作失败!");
            return;
        }
        index++;
        stack[index] = element;
    }

    public int pop() throws RuntimeException {
        if (isEmpty(stack)) {
            System.out.println("栈空,无法弹栈!");
            throw new RuntimeException("栈空!");
        }
        int temp = stack[index];
        index--;
        return temp;
    }

    public void getStackArray() {
        if (isEmpty(stack)) {
            System.out.println("栈空，无数据~");
            return;
        }
        for (int i = index; i >= 0; i--) {
            System.out.printf("栈中的数据为: %d\n", stack[i]);
        }
    }

    private boolean isFull(int[] array) {
        return index == capacity - 1;
    }

    private boolean isEmpty(int[] array) {
        return index == -1;
    }

}
