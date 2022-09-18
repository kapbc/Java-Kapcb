package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: ReverseList </a>
 * <a>Description: ReverseList <a>
 * <a href="https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=295&tqId=23286&ru=%2Fpractice%2F75e878df47f24fdc9dc3e400ec6058ca&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @version 1.0
 * @date 2022/9/1 0:03
 * @since 1.0
 */
public class ReverseList {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.next = two;
        two.next = three;

        one = reverseLinkedList(one);

        System.out.println("one = " + one);

    }

    private static Node reverseLinkedList(Node head) {

        Node pre = null;
        Node next;

        while (head != null) {
            // 记录head的next
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}
