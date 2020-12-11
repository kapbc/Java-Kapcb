package com.kapcb.ccc.java.collection.tree;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * <a>Title: TreeSetTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/17-17:23
 */
public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet<Item> items = new TreeSet<>();
        items.add(new Item(1997, "kapcb"));
        items.add(new Item(1998, "aaaaa"));
        items.add(new Item(1999, "ccccc"));
        items.add(new Item(2000, "ddddd"));
        items.add(new Item(2001, "eeeee"));
        System.out.println(items);
        System.out.println("============================");
        TreeSet<Item> itemTreeSet = new TreeSet<>(Comparator.comparing(Item::getDescription));
        itemTreeSet.addAll(items);
        System.out.println(itemTreeSet);
    }
}
