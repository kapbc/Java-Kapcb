package com.kapcb.ccc.practice.abstractClasses;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Student
 * @date 2020/10/30 10:51
 */
public class Student extends Person {
    private String major;
    
    public Student(){
    
    }

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "A student majoring in " + major;
    }
}
