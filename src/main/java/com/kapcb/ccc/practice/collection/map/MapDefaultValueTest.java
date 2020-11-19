package com.kapcb.ccc.practice.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: MapDefaultValueTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/19-13:42
 */
public class MapDefaultValueTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(6);
        map.put("kapcb", 1);
        map.put("aaaa", 1);
        map.put("ccc", map.getOrDefault("ccc", 0) + 1);
        map.putIfAbsent("ddd", 0);
        map.put("ddd", map.get("ddd") + 1);
        map.merge("kapcb", 1, Integer::sum);
        map.forEach((k, v) -> {
            System.out.println("k = " + k + ", v = " + v);
        });
    }
}
