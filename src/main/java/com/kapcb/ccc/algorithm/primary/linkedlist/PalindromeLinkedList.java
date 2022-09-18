package com.kapcb.ccc.algorithm.primary.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a>Title: LinkedList </a>
 * <a>Author: Kapcb <a>
 * <a>Description: LinkedList <a>
 * <a href="https://www.nowcoder.com/practice/3fed228444e740c8be66232ce8b87c2f?tpId=295&tqId=1008769&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/6 9:55 PM
 * @since 1.0
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        boolean pail = isPail1(head);
        System.out.println("pail = " + pail);

    }

    /**
     * 链表转换为数组，
     *
     * @param head
     * @return
     */
    private static boolean isPail(ListNode head) {

        if (head == null) {
            return false;
        }

        List<Integer> valList = new ArrayList<>();

        while (head != null) {
            valList.add(head.val);
            head = head.next;
        }

        int l = 0;
        int r = valList.size() - 1;

        while (l < r) {

            if (!valList.get(r).equals(valList.get(l))) {
                return false;
            }

            l++;
            r--;

        }

        return true;

    }


    private static boolean isPail3(ListNode head) {

        if (head == null) {
            return false;
        }

        List<Integer> values = new ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int n = values.size();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = values.get(i);
        }

        Collections.reverse(values);

        for (int i = 0; i < n; i++) {
            if (!values.get(i).equals(arr[i])) {
                return false;
            }
        }

        return true;

    }

    private static boolean isPail1(ListNode head) {

        if (head == null) {
            return false;
        }


        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 如果链表长度为奇数，则不需要判断中点位置的值，因为一定相等
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;

    }


    private static ListNode reverse(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;

    }

    private static boolean isPail2(ListNode head) {
        // write code here
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        // 迭代的同时反转慢节点的链表
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // 如果链表长度为奇数, 则跳过中间节点
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && prev != null) {

            if (slow.val != prev.val) {
                return false;
            }

            slow = slow.next;
            prev = prev.next;

        }

        return true;
    }

}
