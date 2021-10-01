package com.kapcb.ccc.code.inter;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Name
 * @date 2020/11/3 9:15
 */
public interface Name {

    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}
