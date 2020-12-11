package com.kapcb.ccc.java.tos;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Employee
 * @date 2020/11/2 11:07
 */
public class Employee {

    private String name;
    private String password;
    private String email;

    public Employee() {
    }

    public Employee(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[ name= " + name + ",password= " + password + ",email= " + email + "]";
    }
}
