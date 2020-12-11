package com.kapcb.ccc.practice.abstractClasses;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Person
 * @date 2020/10/30 10:42
 */
public abstract class Person {

    private String username;

    public abstract String getDescription();

    /**
     * I Hope My Project Won't Tips Too Many Objects That I Don't Want To Use When I Am Coding! Just For Test Data!
     */
    private Person() {
    }

    public Person(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
