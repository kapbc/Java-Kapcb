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

    public Person() {
    }

    public Person(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
