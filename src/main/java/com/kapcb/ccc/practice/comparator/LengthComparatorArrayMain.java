package com.kapcb.ccc.practice.comparator;

import java.util.Arrays;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname LengthComparatorArrayMain
 * @date 2020/11/3 9:37
 */
public class LengthComparatorArrayMain {
    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = new String("kapcb");
        strings[1] = new String("ccc");
        strings[2] = new String("eirc");
        Arrays.sort(strings, new LengthComparator());
        // Comparator 就是只有一个方法的接口，所以可以使用lambda表达式替换
        Arrays.sort(strings, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(strings));
    }
}
