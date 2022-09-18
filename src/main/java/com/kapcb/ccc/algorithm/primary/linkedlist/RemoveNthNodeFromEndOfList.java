package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: RemoveNthNodeFromEndOfList </a>
 * <a>Description: RemoveNthNodeFromEndOfList <a>
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/8/29 22:28
 * @since 1.0
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode listNode = removeNthFromEnd(head, 3);
        System.out.println("listNode = " + listNode);
    }

    /**
     * 快慢指针:
     * 快指针先走n步，然后快慢一起走，直到快指针走到最后，要注意的是可能是要删除第一个节点，这个时候可以直接返回
     *
     * @param head ListNode
     * @param n    int
     * @return ListNode
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode quick = head;

        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }

        if (quick == null) {
            return head.next;
        }

        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;

    }

}
