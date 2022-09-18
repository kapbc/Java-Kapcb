package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: ReverseDoubleList </a>
 * <a>Description: ReverseDoubleList <a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/9/3 10:30
 * @since 1.0
 */
public class ReverseDoubleList {

    public static void main(String[] args) {
        ListNode one = new ListNode(1, null, null);
        ListNode two = new ListNode(2, null, one);
        ListNode three = new ListNode(3, null, two);
        ListNode four = new ListNode(4, null, three);
        ListNode five = new ListNode(5, null, four);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode reverse = reverse(one);
        System.out.println("reverse = " + reverse);
    }

    private static ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {

            ListNode next = cur.next;
            cur.next = prev;
            cur.prev = next;
            prev = cur;
            cur = next;
        }

        return prev;


    }

}
