package com.kapcb.ccc.thread.automic;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: AtomicExample </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AtomicExample <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/3/2 20:49
 * @since 1.0
 */
public class AtomicExample {

    private static int count = 0;

    public synchronized static void increase() {
        count++;
        System.out.println("increase count, current count is : " + count);
    }

    public synchronized static void decrease() {
        count--;
        System.out.println("decrease count, current count is : " + count);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(1 << 4);
        map.put("aaaa", "aaa1");
        map.put("bbbb", "aaa2");
        map.put("cccc", "aaa3");
        map.put("dddd", "aaa4");
        map.put("eeee", "aaa5");
        map.put("ffff", "aaa6");

        map.forEach((key, value) -> System.out.println("key is : " + key + " value is : " + value));
    }

}
