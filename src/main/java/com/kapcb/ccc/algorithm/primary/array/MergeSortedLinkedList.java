package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: MergeSotredLinkedList </a>
 * <a>Description: MergeSotredLinkedList <a>
 *
 * @version 1.0
 * @date 2022/9/3 10:07
 * @since 1.0
 */
public class MergeSortedLinkedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        list1 = mergeByDoublePoint(list1, list2);
        System.out.println("list1 = " + list1);

        ListNode list3 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list4 = new ListNode(2, new ListNode(4, new ListNode(6)));
        list3 = mergeByRecursion(list3, list4);
        System.out.println("list3 = " + list3);
    }

    /**
     * 双指针迭代
     *
     * @param list1 {@link ListNode}
     * @param list2 {@link ListNode}
     * @return {@link ListNode}
     */
    private static ListNode mergeByDoublePoint(ListNode list1, ListNode list2) {

        // 边界条件判断, 其中任意一个链表为空, 返回另外一个即可
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        // 定义一个新表头
        ListNode head = new ListNode(0);
        // 定义 cur 为当前节点, 从 head 开始
        ListNode cur = head;

        // 两个链表都不为空
        while (list1 != null && list2 != null) {
            // 取较小值的节点
            if (list1.val <= list2.val) {
                cur.next = list1;
                //只移动取值的指针
                list1 = list1.next;
            } else {
                //只移动取值的指针
                cur.next = list2;
                list2 = list2.next;
            }
            // 指针后移
            cur = cur.next;
        }

        // 哪个链表还有剩，直接连在后面
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }

        // 返回值去掉表头
        return head.next;

    }

    /**
     * 递归
     *
     * @param list1 {@link ListNode}
     * @param list2 {@link ListNode}
     * @return {@link ListNode}
     */
    private static ListNode mergeByRecursion(ListNode list1, ListNode list2) {
        // 边界条件判断, 其中任意一个链表为空, 返回另外一个即可
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        // 先用较小的值的节点
        if (list1.val < list2.val) {
            // 递归往下
            list1.next = mergeByRecursion(list1.next, list2);
            return list1;
        } else {
            // 递归往下
            list2.next = mergeByRecursion(list1, list2.next);
            return list2;
        }
    }


    private static class ListNode {

        int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
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
