package com.kapcb.ccc.java.reflect;

/**
 * <a>Title: Person </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/21 - 22:42
 */
public class Person {

    /**
     * 最大访问权限
     */
    public String username;
    /**
     * 受保护的
     */
    protected String password;
    /**
     * 默认
     */
    String email;
    /**
     * 私有类型
     */
    private String flag;

    public Person() {
    }

    /**
     * 单个参数的构造函数，且为私有构造方法
     *
     * @param username String
     */
    private Person(String username) {
        this.username = username;
    }

    public Person(String username, String password, String email, String flag) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.flag = flag;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
