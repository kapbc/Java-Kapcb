package com.kapcb.ccc.practice.collection.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a>Title: LinkedHashMapTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/19-14:49
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("aaa", "1111");
        map.put("bbb", "2222");
        map.put("ccc", "3333");
        map.put("ddd", "4444");
        map.put("eee", "5555");
        map.put("fff", "6666");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("===================");
        Iterator<String> valueIterator = map.values().iterator();
        while (valueIterator.hasNext()) {
            String next = valueIterator.next();
            System.out.println(next);
        }
    }
}
