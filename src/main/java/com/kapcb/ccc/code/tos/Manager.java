package com.kapcb.ccc.code.tos;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Manager
 * @date 2020/11/2 11:10
 */
public class Manager extends Employee {
    private String bonus;

    public Manager() {
        super();
    }

    public Manager(String name, String password, String email, String bonus) {
        super(name, password, email);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus= " + bonus + "]";
    }
}
