package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: DeleteAllDuplicatesInLinkedList </a>
 * <a>Description: DeleteAllDuplicatesInLinkedList <a>
 * <a href="https://www.nowcoder.com/practice/71cef9f8b5564579bf7ed93fbe0b2024?tpId=295&tqId=663&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @version 1.0
 * @date 2022/9/7 16:27
 * @since 1.0
 */
public class DeleteAllDuplicatesInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(5))))))));
        ListNode listNode = deleteDuplicates(head);
        System.out.println("listNode = " + listNode);
    }

    private static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode cur = result;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int duplicateValue = cur.next.val;
                while (cur.next != null && duplicateValue == cur.next.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return result.next;

    }
}
