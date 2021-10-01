package com.kapcb.ccc.code.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: MapTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/18-15:01
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(6);
        map.put("1", "kapcb");
        map.put("2", "ccccc");
        map.put("3", "dsads");
        map.put("4", "eeeee");
        map.put("5", "bbbbb");
        map.put("6", "fffff");
        map.put("7", "ggggg");

        System.out.println(map);

        map.remove("6");

        map.put("11", "aoligei");

        System.out.println(map.get("1"));

        map.forEach((k, v) -> System.out.println("k:" + k + ", v:" + v));

    }
}
