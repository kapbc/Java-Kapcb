package com.kapcb.ccc.algorithm.leetcode.junior;

/**
 * <a>Title: MiddleOfLinkedList </a>
 * <a>Description: MiddleOfLinkedList <a>
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">...</a>
 * @version 1.0
 * @date 2022/8/29 19:34
 * @since 1.0
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode listNode = middleNode(head);
        System.out.println("listNode = " + listNode);

//        ListNode listNode1 = middleNodeSpaceInIime(head);
//        System.out.println("listNode1 = " + listNode1);

    }

    /**
     * 双指针:
     * 利用快慢指针，快指针每次走两步，慢指针每次走一步，所以快指针走的距离为慢指针的两倍，
     * 故当快指针遍历到链表末尾时，慢指针指向记为中间节点
     *
     * @param head ListNode
     * @return ListNode
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     * 空间换时间:
     *
     * @param head
     * @return
     */
    public static ListNode middleNodeSpaceInIime(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode[] arr = new ListNode[]{};
        arr[0] = head;
        int count = 1;
        while (head != null && head.next != null) {
            arr[count]=head.next;
            count++;
        }
        return null;
    }

    private static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
