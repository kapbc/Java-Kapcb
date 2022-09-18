package com.kapcb.ccc.algorithm.primary.linkedlist;

import java.util.HashSet;

/**
 * <a>Title: LinkedListHasCycle </a>
 * <a>Description: LinkedListHasCycle <a>
 * <a href="https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=295&tqId=605&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/9/3 21:40
 * @since 1.0
 */
public class LinkedListHasCycle {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = three;
        boolean hasCycle = hasCycleByHashSet(one);
        System.out.println("hasCycle = " + hasCycle);
    }

    private static boolean hasCycle(ListNode head) {

        // 边界条件判断
        if (head == null) {
            return false;
        }

        // 快慢双指针
        ListNode fast = head;
        ListNode slow = head;

        // 如果没环快指针会先到链表尾
        while (fast != null && fast.next != null) {

            // 快指针移动两步
            fast = fast.next.next;
            // 慢指针移动一步
            slow = slow.next;

            // 相遇则有环
            if (fast == slow) {
                return true;
            }

        }

        // 到末尾则没有环
        return false;

    }

    private static boolean hasCycleByHashSet(ListNode head) {

        // 边界条件判断
        if (head == null) {
            return false;
        }

        ListNode cur = head;

        // 哈希表记录访问过的结点
        HashSet<ListNode> nodeSet = new HashSet<>();

        while (cur != null) {
            // 判断结点是否被访问
            if (nodeSet.contains(cur)) {
                return true;
            }
            // 结点记录添加到哈希表中
            nodeSet.add(cur);
            // 遍历
            cur = cur.next;
        }

        return false;

    }

}
