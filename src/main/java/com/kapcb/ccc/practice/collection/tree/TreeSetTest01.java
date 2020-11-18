package com.kapcb.ccc.practice.collection.tree;

import java.util.Set;
import java.util.TreeSet;

/**
 * <a>Title: TreeSetTest01 </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/18-14:01
 */
public class TreeSetTest01 {

    public static void main(String[] args) {

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("kapcb");
        treeSet.add("aaaaa");
        treeSet.add("ccccc");
        treeSet.add("bbbbb");
        treeSet.stream().forEach(System.out::println);
    }
}
