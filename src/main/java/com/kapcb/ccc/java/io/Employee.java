package com.kapcb.ccc.java.io;

/**
 * <a>Title: Manager </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6-14:20
 */
public class Manager extends Employee {

    private Employee secretary;

    public Manager() {
        super();
        secretary = null;
    }

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        secretary = null;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    public Employee getSecretary() {
        return this.secretary;
    }

    @Override
    public String toString() {
        return  super.toString() +
                " secretary=" + secretary +
                '}';
    }
}
