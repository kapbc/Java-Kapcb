package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: ListNode </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ListNode <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/18 10:05 PM
 * @since 1.0
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode prev;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }

}
