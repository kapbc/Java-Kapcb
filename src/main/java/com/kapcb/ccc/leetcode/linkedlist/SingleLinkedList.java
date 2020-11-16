package com.kapcb.ccc.leetcode.linkedlist;

/**
 * <a>Title: SingleLinkedList </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/16 - 20:18
 */
public class SingleLinkedList {

    private ListNode node = new ListNode(0, "");

    /**
     * 向链表中添加元素
     *
     * @param listNode ListNode
     * @return boolean
     */
    public void add(ListNode listNode) {
        ListNode head = node;
        while (true) {
            if (head.getNextNode() == null) {
                break;
            }
            head = head.getNextNode();
        }
        head.setNextNode(listNode);
    }

    /**
     * 显示链表中的元素
     */
    public void list() {
        if (node.getNextNode() == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode head = node.getNextNode();
        while (true) {
            if (head == null) {
                break;
            }
            System.out.println(head);
            head = head.getNextNode();
        }
    }
}
