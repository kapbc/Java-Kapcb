package com.kapcb.ccc.java.equals;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Employee
 * @date 2020/10/30 13:43
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }

        Employee obj = (Employee) object;
        return Objects.equals(name, obj.getName()) && salary == obj.getSalary() && Objects.equals(hireDay, obj.hireDay);
    }
}
