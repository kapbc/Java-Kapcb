package com.kapcb.ccc.datastructure;


import java.util.logging.Logger;

/**
 * <a>Title: KapcbLinkedList </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/17-10:46
 * 自己实现的 单链表 -- KapcbLinkedList
 */
public class KapcbLinkedList<E> {

    private static final Logger logger = Logger.getLogger(String.valueOf(KapcbLinkedList.class), "logmessage_en");

    transient int size = 0;

    private Node temp = new Node(null);

    public void add(E e) {
        Node node = temp;
        while (true) {
            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        Node<E> eNode = new Node<>(e);
        node.next = eNode;
        eNode.prev = node;
        size++;
    }

    public void list() {
        if (temp.next == null) {
            logger.warning("kapcb.linkedlist.error");
        }
        Node node = temp.next;
        while (true) {
            if (node == null) {
                break;
            }
            System.out.println(node);
            node = node.next;
        }
    }

    public void remove() {
        if (temp.next == null) {
            logger.warning("kapcb.linkedlist.error");
        }
        Node node = temp;
        while (true) {
            if (node.next == null) {
                size--;
                node.prev.next = null;
                break;
            }
            node = node.next;
        }
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node() {
        }

        Node(E data) {
            this.data = data;
        }

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
