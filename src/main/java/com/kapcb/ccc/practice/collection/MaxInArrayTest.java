package com.kapcb.ccc.practice.collection;

import com.kapcb.ccc.practice.collection.MaxInArray;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: MaxInArrayTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-13:43
 */
public class MaxInArrayTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);

        Integer max = MaxInArray.getMaxInArray(list);
        System.out.println(max);
    }
}
