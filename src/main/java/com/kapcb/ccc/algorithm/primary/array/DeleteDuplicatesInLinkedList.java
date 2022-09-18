package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: DeleteDuolinp </a>
 * <a>Description: DeleteDuolinp <a>
 * <a href="https://www.nowcoder.com/practice/c087914fae584da886a0091e877f2c79?tpId=295&tqId=664&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @version 1.0
 * @date 2022/9/7 15:24
 * @since 1.0
 */
public class DeleteDuplicatesInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4)))));

        ListNode listNode = deleteDuplicates(head);
        System.out.println("listNode = " + listNode);
    }


    private static ListNode deleteDuplicates(ListNode head) {
        // write code here

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;

    }
}
