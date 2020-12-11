package com.kapcb.ccc.java.inter;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Person
 * @date 2020/11/3 9:14
 */
public interface Person {

    default String getName() {
        return "kapcb";
    }
}
