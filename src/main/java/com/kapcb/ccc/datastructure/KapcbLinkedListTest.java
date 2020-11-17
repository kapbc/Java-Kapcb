package com.kapcb.ccc.datastructure;

/**
 * <a>Title: KapcbLinkedListTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/17-11:30
 */
public class KapcbLinkedListTest {

    public static void main(String[] args) {

        KapcbLinkedList<String> linkedList = new KapcbLinkedList<>();
        linkedList.add("kapcb");
        linkedList.add("bbbbb");
        linkedList.add("ccccc");
        linkedList.add("ddddd");
        linkedList.add("eeeee");
        linkedList.add("fffff");
        linkedList.list();
        System.out.println(linkedList.size);
        System.out.println("--------------------");
        linkedList.remove();
        linkedList.list();
        System.out.println(linkedList.size);

    }
}
