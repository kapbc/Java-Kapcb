package com.kapcb.ccc.datastructure;

/**
 * <a>Title: KpacbStackTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/17 - 21:25
 */
public class KpacbStackTest {

    public static void main(String[] args) {
        KapcbStack stack = new KapcbStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        System.out.println("stack.size() = " + stack.size());
        stack.list();
        int peek = stack.peek();
        System.out.println("peek = " + peek);
        int pop = stack.pop();
        System.out.println("pop = " + pop);
        System.out.println("stack.size() = " + stack.size());
        stack.list();
    }
}
