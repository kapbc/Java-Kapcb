package com.kapcb.ccc.practice.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * <a>Title: IteratorTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/16-15:38
 */
public class IteratorTest {

    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();
        collection.add("kapcb");
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("ddd");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        
        iterator.forEachRemaining(element -> {System.out.println(element);});
    }
}
