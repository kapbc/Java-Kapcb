package com.kapcb.ccc.algorithm.primary.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: ReverseLinkedListOfSpecifiedRange </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ReverseLinkedListOfSpecifiedRange <a>
 * <a href="https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=295&tqId=654&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/18 11:34 PM
 * @since 1.0
 */
public class ReverseLinkedListOfSpecifiedRange {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = reverseBetween(head, 2, 4);
        System.out.println("listNode = " + listNode);
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here

        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode pre = res;
        ListNode cur = head;

        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return res.next;

    }

    private static ListNode reverseBetween1(ListNode head, int m, int n) {
        // write code here

        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> valList = new ArrayList<>();

        ListNode cur = head;

        while (cur != null) {
            valList.add(cur.val);
            cur = cur.next;
        }

        int l = valList.size();

        int[] arr = new int[l];

        for (int i = 0; i < l; i++) {
            arr[i] = valList.get(i);
        }

        m -= 1;
        n -= 1;

        while (m < n) {
            swap(arr, m++, n--);
        }

        ListNode prev = new ListNode(-1);
        ListNode t = prev;

        for (int i = 0; i < l; i++) {
            t.next = new ListNode(arr[i]);
            t = t.next;
        }

        return prev.next;

    }

    private static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

}
