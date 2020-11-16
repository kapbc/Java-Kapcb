package com.kapcb.ccc.leetcode;

/**
 * <a>Title: ReverseLinkedList </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/16-13:56
 * <p>
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * link: https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {


    public static void main(String[] args) {
        kapcbLinkedList<Integer> linkedList = new kapcbLinkedList<>();
    }

}

class kapcbLinkedList<E> {

    private Node<E> root;

    private E next;

    public void add(Node<E> element){
        if (root.getNext()==null){
            root.setNext(element);
            element.setNext(null);
        }
    }

    public void remove(){
        
    }
}

class Node<E> {
    private E data;

    private Node<E> next;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public boolean add(E node){
        Node<E> newNode = new Node<>();
        if (this.next==null) {

        }
    }
}
