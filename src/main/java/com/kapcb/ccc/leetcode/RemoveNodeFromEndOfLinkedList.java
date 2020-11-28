package com.kapcb.ccc.leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <a>Title: RemoveNodeFromEndOfLinkedList </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/28 - 13:53
 * <p>
 * link: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNodeFromEndOfLinkedList {


    public static void main(String[] args) {
        removeNthFromEnd(2);
    }

    private static void removeNthFromEnd(int index) {
        LinkedListForLeetCode linkedListForLeetCode = new LinkedListForLeetCode();
        linkedListForLeetCode.add("1");
        linkedListForLeetCode.add("2");
        linkedListForLeetCode.add("3");
        linkedListForLeetCode.add("4");
        linkedListForLeetCode.add("5");
        linkedListForLeetCode.remove(3);
        linkedListForLeetCode.list();
    }

}

class LinkedListForLeetCode {

    private static final Logger logger = Logger.getLogger(String.valueOf(LinkedListForLeetCode.class), "logmessage_en");

    private Node head = new Node("", null, null);

    private int size = 0;

    public LinkedListForLeetCode() {
    }

    class Node {
        String node;
        Node pre;
        Node next;

        Node() {
        }

        Node(String node, Node pre, Node next) {
            this.node = node;
            this.next = next;
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "Node[ node= " + this.node + ", pre= " + this.pre + ", next= " + this.next + "]";
        }
    }

    public void add(String value) {
        Node node = new Node(value, null, null);
        while (true) {
            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        head.next = node;
        node.pre = head;
        size++;
    }

    public void remove(int index) {
        if (isEmpty()) {
            logger.warning("kapcb.linkedlist.error");
            return;
        }
        Node temp = head.next;
        int count = 0;
        while (true) {
            if (temp == null) {
                break;
            }
            if (count == index && temp.next != null) {
                temp.next.pre = temp.pre;
                temp.pre.next = temp.next;
                temp = null;
                break;
            }
            if (count == index && temp.next != null) {
                temp.pre.next = null;
                temp = null;
            }
            temp = temp.next;
            size--;
            count++;
        }
    }

    public void list() {
        if (isEmpty()) {
            logger.warning("kapcb.linkedlist.error");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }

    }


    public boolean isEmpty() {
        return size == 0 ? true : false;
    }


}
