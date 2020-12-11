package com.kapcb.ccc.practice.abstractClasses;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Student
 * @date 2020/10/30 10:51
 */
public class Student extends Person {
    private String major;
    
    /**
     * I Hope My Project Won't Tips Too Many Objects That I Don't Want To Use When I Am Coding! Just For Test Data!
     */
    private Student(){
    
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
