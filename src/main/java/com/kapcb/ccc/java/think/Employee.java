package com.kapcb.ccc.java.think;


import java.time.LocalDate;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Employee
 * @date 2020/10/30 8:48
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    /**
     * I Hope My Project Won't Tips Too Many Objects That I Don't Want To Use When I Am Coding! Just For Test Data!
     */
    private Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }
    
    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }


    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[ name =" + name + ", salary=" + salary + ", hireDay=" + hireDay + " ]";
    }
}
