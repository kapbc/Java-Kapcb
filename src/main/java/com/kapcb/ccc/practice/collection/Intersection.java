package com.kapcb.ccc.practice.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * <a>Title: Intersection </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/26-11:05
 */
public class Intersection {
    public static void main(String[] args) {

        Set<String> setOne = new HashSet<>();
        Set<String> setTwo = new HashSet<>();
        setOne.add("kapcb");
        setOne.add("ccc");
        setOne.add("aaa");
        setOne.add("bbb");
        setTwo.add("111");
        setTwo.add("bbb");

        setOne.removeAll(setTwo);
        setOne.forEach(System.out::println);

        setOne.retainAll(setTwo);
        if (setOne.size() == 0) {
            System.out.println("kapcb nb");
            return;
        }
        setOne.forEach(System.out::println);
    }
}
