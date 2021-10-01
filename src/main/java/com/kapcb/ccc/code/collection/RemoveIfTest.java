package com.kapcb.ccc.code.collection;

import java.util.LinkedList;
import java.util.List;

/**
 * <a>Title: RemoveIfTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/16-16:24
 */
public class RemoveIfTest {

    public static void main(String[] args) {

        List<String> linkedList = new LinkedList<>();
        linkedList.add("kapcb");
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("ccc");
        linkedList.add("ddd");
        linkedList.add("eee");
        linkedList.add("fff");
        linkedList.removeIf(element -> element.equalsIgnoreCase("aaa"));
        System.out.println(linkedList.contains("aaa"));
        for (String s : linkedList) {
            System.out.println(s);
        }
    }
}
