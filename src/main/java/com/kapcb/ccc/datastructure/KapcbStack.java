package com.kapcb.ccc.datastructure;

import com.kapcb.ccc.util.Constants;

import java.util.logging.Logger;

/**
 * <a>Title: KapcbStack </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/17-13:14
 */
public class KapcbStack {

    private static final Logger logger = Logger.getLogger(String.valueOf(KapcbStack.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    private int head = -1;
    private int size = 0;
    private int capacity;
    private int[] array;

    public KapcbStack() {
        this.capacity = 10;
        array = new int[capacity];
    }

    public KapcbStack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    private boolean isFull(int[] array) {
        return head + 1 == this.capacity ? true : false;
    }

    private boolean isEmpty(int[] array) {
        return head == -1 ? true : false;
    }

    public void push(int e) {
        if (isFull(array)) {
            logger.warning("kapcb.stack.full.error");
            return;
        }
        head++;
        array[head] = e;
        size++;
    }

    public int peek() {
        if (isEmpty(array)) {
            logger.warning("kapcb.stack.empty.error");
            return 0;
        }
        return array[head];
    }

    public int pop() {
        if (isEmpty(array)) {
            logger.warning("kapcb.stack.empty.error");
            return 0;
        }
        int temp = array[head];
        head--;
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    public void list() {
        if (isEmpty(array)) {
            logger.warning("kapcb.stack.empty.error");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.printf("栈中的数据为:%d\n" , array[i]);
        }
    }
}
