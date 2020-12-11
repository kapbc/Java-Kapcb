package com.kapcb.ccc.algorithm.leetcode.linkedlist;

/**
 * <a>Title: ListNode </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/16 - 20:13
 */
public class ListNode {

    private Integer id;
    private String name;
    private ListNode nextNode;

    public ListNode() {
    }

    public ListNode(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[ id =" + this.id + ",name = " + this.name + " ]";
    }
}
