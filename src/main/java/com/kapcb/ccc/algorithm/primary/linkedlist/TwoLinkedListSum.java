package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: TwoLinkedListSum </a>
 * <a>Description: TwoLinkedListSum <a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/9/16 12:48
 * @since 1.0
 */
public class TwoLinkedListSum {

    public static void main(String[] args) {

    }

    private static ListNode addInList(ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode node1 = head1;
        ListNode node2 = head2;

        ListNode res = new ListNode(0);
        int temp = 0;
        while (node1 != null && node2 != null) {
            int v = node1.val + node2.val;
            temp = v % 10;

        }

        return res.next;
    }
}
