package com.kapcb.ccc.practice.collection.map;

import com.kapcb.ccc.practice.collection.set.EnumElement;
import com.kapcb.ccc.practice.think.Employee;

import java.util.EnumMap;
import java.util.Map;

/**
 * <a>Title: EnumMap </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-8:47
 */
public class EnumMapTest {
    public static void main(String[] args) {
        Map<EnumElement, Employee> enumMap = new EnumMap<>(EnumElement.class);
        enumMap.put(EnumElement.MONDAY, new Employee("kapcb", 5000, 1997, 03, 11));
        enumMap.put(EnumElement.THURSDAY, new Employee("ccccc", 4000, 1998, 04, 13));
        enumMap.put(EnumElement.WEDNESDAY, new Employee("eeeee", 3000, 1999, 05, 15));
        enumMap.put(EnumElement.TUESDAY, new Employee("bbbbb", 2000, 1996, 06, 17));

        enumMap.forEach((k, v) -> System.out.println("k = " + k + ", v = " + v.toString()));
    }
}
