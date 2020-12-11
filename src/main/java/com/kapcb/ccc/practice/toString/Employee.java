package com.kapcb.ccc.practice.toString;

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

    /**
     * I Hope My Project Won't Tips Too Many Objects That I Don't Want To Use When I Am Coding! Just For Test Data!
     */
    private Employee() {
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
