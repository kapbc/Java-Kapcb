package com.kapcb.ccc.java.annotation.bean;

import com.kapcb.ccc.java.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * <a>Title: Person </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/15-11:20
 */
public class Person {

    @Nullable(value = true)
    private Long userId;

    @Nullable(value = true)
    private String username;

    @Nullable(value = true)
    private String password;

    private Integer age;

    @Nullable(value = true)
    private LocalDateTime birthday;

    public Person() {
    }

    public Person(Long userId, String username, String password, Integer age, LocalDateTime birthday) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.age = age;
        this.birthday = birthday;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
