package com.kapcb.ccc.java.reflect.tdd;


import java.time.LocalDateTime;

/**
 * <a>Title: Person </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/28-16:07
 */
public class Person {

    @Column(name = "user_name")
    private String username;

    @Column(name = "pass_word")
    private String password;

    @Column(name = "l_upd_date")
    private LocalDateTime lastUpdateDate;

    public Person() {
    }

    public Person(String username, String password, LocalDateTime lastUpdateDate) {
        this.username = username;
        this.password = password;
        this.lastUpdateDate = lastUpdateDate;
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

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
