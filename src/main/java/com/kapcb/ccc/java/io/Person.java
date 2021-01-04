package com.kapcb.ccc.java.io;

import java.time.LocalDateTime;

/**
 * <a>Title: Person </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/4-14:21
 */
public class Person {

    private String name;
    private String email;
    private int age;
    private LocalDateTime birthday;

    public Person() {
    }

    public Person(String name, String email, int age, LocalDateTime birthday) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
