package com.kapcb.ccc.algorithm.leetcode.linkedlist;

import java.util.Iterator;
import java.util.Stack;

/**
 * <a>Title: ReverseLinkedList </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/16 - 20:12
 *
 * <p>
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * link: https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, "kapcb");
        ListNode listNode2 = new ListNode(2, "ccccc");
        ListNode listNode3 = new ListNode(3, "bbbbb");
        ListNode listNode4 = new ListNode(4, "ddddd");
        ListNode listNode5 = new ListNode(5, "eeeee");

        SingleLinkedList singleLinkedList = new SingleLinkedList();


        singleLinkedList.list();

        System.out.println("=================================");

        Stack<ListNode> nodeStack = new Stack<>();
        nodeStack.push(listNode1);
        nodeStack.push(listNode2);
        nodeStack.push(listNode3);
        nodeStack.push(listNode4);
        nodeStack.push(listNode5);
        Iterator<ListNode> iterator = nodeStack.iterator();
        for (int i = 0; i < 5; i++) {
            singleLinkedList.add(nodeStack.pop());
        }
        singleLinkedList.list();
    }
}
