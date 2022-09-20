package com.kapcb.ccc.algorithm.primary.linkedlist;

/**
 * <a>Title: ParityRearrangementOfLinkedList </a>
 * <a>Author: Kapcb <a>
 * <a>Description: 链表的奇偶重排 <a>
 * <a href="https://www.nowcoder.com/practice/02bf49ea45cd486daa031614f9bd6fc3?tpId=295&tqId=1073463&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/20 10:35 PM
 * @since 1.0
 */
public class ParityRearrangementOfLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode listNode = oddEvenList(head);
        System.out.println("listNode = " + listNode);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 奇数链表
        ListNode odd = head;

        // 偶数链表
        ListNode even = head.next;

        // 抓住偶数链表的头部
        ListNode evenHead = even;

        // 偶数节点的后节点即为奇数链表的后一个节点
        // 奇数节点的后节点即为偶数链表的后一个节点
        while (even != null && even.next != null) {
            // odd连接even的后一个，即奇数位
            odd.next = even.next;
            // odd进入后一个奇数位
            odd = odd.next;
            // even连接后一个奇数的后一位，即偶数位
            even.next = odd.next;
            // even进入后一个偶数位
            even = even.next;
        }
        // even整体接在odd后面
        odd.next = evenHead;

        return head;

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode oddEvenList1(ListNode head) {
        // write code here

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = new ListNode(-1);
        ListNode l1 = odd;
        ListNode even = new ListNode(-1);
        ListNode l2 = even;

        int index = 1;
        while (head != null) {
            if (index % 2 == 0) {
                l2.next = new ListNode(head.val);
                l2 = l2.next;
            } else {
                l1.next = new ListNode(head.val);
                l1 = l1.next;
            }
            head = head.next;
            index++;
        }

        l1.next = even.next;

        return odd.next;

    }


}
