package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: ReverseDoubleList </a>
 * <a>Description: ReverseDoubleList <a>
 *
 * @version 1.0
 * @date 2022/9/3 10:30
 * @since 1.0
 */
public class ReverseDoubleList {

    public static void main(String[] args) {

    }

    private static class ListNode {

        int val;

        ListNode pre;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode pre, ListNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", pre=" + pre +
                    ", next=" + next +
                    '}';
        }
    }

}
