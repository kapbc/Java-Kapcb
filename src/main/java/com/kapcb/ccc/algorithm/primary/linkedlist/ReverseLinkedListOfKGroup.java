package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: ReverseLinkedListOfKGroup </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ReverseLinkedListOfKGroup <a>
 * <a href="https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=295&tqId=722&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/19 10:58 PM
 * @since 1.0
 */
public class ReverseLinkedListOfKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode listNode = reverseKGroup(head, 3);
        System.out.println("listNode = " + listNode);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        // write code here

        ListNode tail = head;

        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode pre = null;

        ListNode cur = head;

        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = reverseKGroup(tail, k);
        return pre;

    }
}
