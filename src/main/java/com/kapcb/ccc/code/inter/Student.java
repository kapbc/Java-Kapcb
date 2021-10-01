package com.kapcb.ccc.code.inter;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Student
 * @date 2020/11/3 9:16
 */
public class Student implements Person, Name {
    @Override
    public String getName() {
        return Person.super.getName();
    }
}
