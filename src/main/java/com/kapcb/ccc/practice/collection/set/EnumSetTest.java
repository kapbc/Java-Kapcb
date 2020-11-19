package com.kapcb.ccc.practice.collection.set;

import java.util.EnumSet;

/**
 * <a>Title: EnumSetTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/19-15:26
 */
public class EnumSetTest {
    public static void main(String[] args) {
        EnumSet<EnumElement> always = EnumSet.allOf(EnumElement.class);
        EnumSet<EnumElement> never = EnumSet.noneOf(EnumElement.class);
        EnumSet<EnumElement> workDay = EnumSet.range(EnumElement.MONDAY, EnumElement.FRIDAY);
        EnumSet<EnumElement> mwf = EnumSet.of(EnumElement.MONDAY, EnumElement.WEDNESDAY, EnumElement.FRIDAY);
        always.forEach(System.out::println);
    }
}
