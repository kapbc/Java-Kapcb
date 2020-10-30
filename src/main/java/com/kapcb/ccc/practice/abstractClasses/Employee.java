package com.kapcb.ccc.practice.abstractClasses;

import java.time.LocalDate;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Employee
 * @date 2020/10/30 10:44
 */
public class Employee extends Person {
    private double salary;
    private LocalDate hireDay;

    public Employee() {
    }

    public Employee(String name, double salary, int year, int month, int dat) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, dat);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public String getDescription() {
        return String.format("An employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
