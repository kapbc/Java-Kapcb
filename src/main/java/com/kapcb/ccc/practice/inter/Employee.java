package com.kapcb.ccc.practice.inter;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Employee
 * @date 2020/11/2 16:00
 */
public class Employee implements Comparable<Employee> {

    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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


    @Override
    public int compareTo(Employee employee) {
        return Double.compare(salary, employee.salary);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + "]";
    }
}
