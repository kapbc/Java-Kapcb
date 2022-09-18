package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: TwoListCommonNode </a>
 * <a>Description: TwoListCommonNode <a>
 * <a href="https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=295&tqId=23257&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @version 1.0
 * @date 2022/9/4 9:49
 * @since 1.0
 */
public class TwoListCommonNode {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);

        one.next = two;
        two.next = three;
        three.next = six;
        six.next = seven;

        four.next = five;
        five.next = six;

        ListNode firstCommonNode = findFirstCommonNode(one, four);
        System.out.println("firstCommonNode = " + firstCommonNode);
    }

    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        // 边界条件判断
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {

            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;

        }

        return p1;
    }

}
