package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: TwoLinkedListSum </a>
 * <a>Description: TwoLinkedListSum <a>
 * <a href="https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=295&tqId=1008772&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/9/16 12:48
 * @since 1.0
 */
public class TwoLinkedListSum {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode head2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode listNode = addInList(head1, head2);
        System.out.println("listNode = " + listNode);

    }

    private static ListNode addInList(ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // 反转链表进行对位
        ListNode l1 = reverseList(head1);
        ListNode l2 = reverseList(head2);

        ListNode res = new ListNode(0);
        ListNode cur = res;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + temp;
            temp = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);

            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (temp == 1) {
            cur.next = new ListNode(temp);
        }

        // 将接口再反转返回结果
        return reverseList(res.next);
    }

    // 反转链表
    private static ListNode reverseList(ListNode listNode) {

        if (listNode == null) {
            return null;
        }

        ListNode res = listNode;
        ListNode prev = null;

        while (res != null) {
            ListNode next = res.next;
            res.next = prev;
            prev = res;
            res = next;
        }
        return prev;
    }
}
