package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: CountDownLastKNode </a>
 * <a>Description: CountDownLastKNode <a>
 * <a href="https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=295&tqId=1377477&ru=%2Fpractice%2F650474f313294468a4ded3ce0f7898b9&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/9/3 22:37
 * @since 1.0
 */
public class CountDownLastKNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode kthToTail = findKthToTail(listNode, 2);
        System.out.println("kthToTail = " + kthToTail);
    }

    private static ListNode findKthToTail(ListNode pHead, int k) {

        // 边界条件判断
        if (pHead == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        // 快指针先行k步
        for (int i = 1; i <= k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                // 达不到k步说明链表过短，没有倒数k
                return null;
            }
        }

        // 快慢指针同步，快指针先到底，慢指针指向倒数第k个
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

    private static ListNode findKthToTail1(ListNode pHead, int k) {

        if (pHead == null) {
            return null;
        }

        ListNode cur = pHead;

        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        if (k > n) {
            return null;
        }

        cur = pHead;

        for (int i = 0; i < n - k; i++) {
            cur = cur.next;
        }

        return cur;

    }

}
