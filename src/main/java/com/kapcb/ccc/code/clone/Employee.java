package com.kapcb.ccc.code.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Employee
 * @date 2020/11/3 10:06
 */
public class Employee implements Cloneable{

    private String name;
    private double salary;
    private Date hireDay;

    /**
     * I Hope My Project Won't Tips Too Many Objects That I Don't Want To Use When I Am Coding! Just For Test Data!
     */
    private Employee() {
    }

    public Employee(String name, double salary, Date hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        // call Object clone() method
        Employee clone = (Employee) super.clone();

        // clone mutable fields
        clone.hireDay = (Date) hireDay.clone();

        return clone;
    }

    /**
     * Set the hire day to a given date
     *
     * @param year  the year of the hire day
     * @param month the month of the hire day
     * @param day   the day of the hire day
     */
    public void setHireDay(int year, int month, int day) {
        Date time = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(time.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
