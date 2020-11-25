package com.kapcb.ccc.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * <a>Title: MapApiTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/25 - 20:54
 */
public class MapApiTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(6);
        map.put("type", "kapcb");
        map.forEach((k, v) -> {
            System.out.println("k: " + k + ", v: " + v);
        });
        map.merge("type", "T000", (oldValue, newValue) -> oldValue = newValue);

        map.forEach((k, v) -> {
            System.out.println("k: " + k + ", v: " + v);
        });

        map.merge("type", "ccc", new BiFunction<String, String, String>() {
            @Override
            public String apply(String o, String o2) {
                return o = o2;
            }
        });

        map.forEach((k, v) -> {
            System.out.println("k: " + k + ", v: " + v);
        });

        map.merge("type", "123", String::concat);

        map.forEach((k, v) -> {
            System.out.println("k: " + k + ", v: " + v);
        });
    }
}
