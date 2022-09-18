package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: Node </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Node <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/18 10:32 PM
 * @since 1.0
 */
public class Node {

    int val;

    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

}
