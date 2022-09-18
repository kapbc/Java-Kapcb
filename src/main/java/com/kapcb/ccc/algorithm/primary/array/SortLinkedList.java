package com.kapcb.ccc.algorithm.primary.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a>Title: SortLinkedList </a>
 * <a>Description: SortLinkedList <a>
 * <a href="https://www.nowcoder.com/practice/f23604257af94d939848729b1a5cda08?tpId=295&tqId=1008897&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @version 1.0
 * @date 2022/9/7 10:23
 * @since 1.0
 */
public class SortLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode listNode = sortInList(head);
        System.out.println("listNode = " + listNode);
    }

    /**
     * 单链表排序
     *
     * @param head {@link ListNode}
     * @return {@link ListNode}
     */
    public static ListNode sortInList(ListNode head) {

        // 边界条件判断
        if (head == null) {
            return null;
        }

        List<Integer> nodeList = new ArrayList<>();

        ListNode cur = head;

        while (cur != null) {
            nodeList.add(cur.val);
            cur = cur.next;
        }

        Collections.sort(nodeList);

        ListNode result = new ListNode(0);
        ListNode temp = result;

        for (Integer val : nodeList) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        return result.next;

    }


    private static ListNode sortInList1(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head;

        while (right != null && right.next != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }

        return null;

    }

}
