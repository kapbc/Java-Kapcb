package com.kapcb.ccc.practice.collection;

import java.util.Arrays;
import java.util.List;

/**
 * <a>Title: ListAndArrayConvert </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/27-14:04
 */
public class ListAndArrayConvert {

    public static void main(String[] args) {

        String[] arrayString = {"kapcb", "awesome", "nb", "handsome", "cool"};

        List<String> stringList = Arrays.asList(arrayString);
        // Set<String> strings = new HashSet<String>(List.of(arrayString));  java 9
        String[] array = stringList.toArray(new String[0]);


        System.out.println(stringList);
        System.out.println(Arrays.toString(array));
    }
}
