package com.kapcb.ccc.algorithm.leetcode;


/**
 * <a>Title: TwoLinkNumSum </a>
 * <a>Author: Mike Chen <a>
 * <a>Description: TwoLinkNumSum <a>
 *
 * @author Mike Chen
 * @date 2022/2/21 10:47
 */
public class TwoLinkNumSum {

    private TwoLinkNumSum() {
    }

    private static ListNode doTwoLinkNumSum(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);

            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    static class ListNode {
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

    public static void main(String[] args) {
        ListNode listOne = new ListNode(2);
        ListNode listTwo = new ListNode(4);
        listOne.next = listTwo;
        ListNode listThree = new ListNode(3);
        listTwo.next = listThree;

        ListNode listFour = new ListNode(5);
        ListNode listFive = new ListNode(6);
        listFour.next = listFive;
        ListNode listSix = new ListNode(4);
        listFive.next = listSix;

        ListNode listNode = doTwoLinkNumSum(listOne, listFour);
        System.out.println("listNode = " + listNode);
    }

}
