package com.kapcb.ccc.java.io.objectstream;

import com.kapcb.ccc.java.io.bean.Employee;
import com.kapcb.ccc.java.io.bean.Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <a>Title: ObjectStreamTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6-14:24
 */
public class ObjectStreamTest {

    private static final String SPILT = File.separator;
    private static final String INPUT_PATH = "src" + SPILT + "main" + SPILT + "resource" + SPILT + "dat" + SPILT + "employee.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee secretaryOne = new Employee("kapcb", 5000, 2020, 06, 23);
        Manager kapcb = new Manager("managerOne", 80000, 1997, 03, 11);
        Manager ccc = new Manager("managerTwo", 70000, 1998, 04, 13);
        kapcb.setSecretary(secretaryOne);
        ccc.setSecretary(secretaryOne);

        Employee[] employees = new Employee[3];
        employees[0] = secretaryOne;
        employees[1] = kapcb;
        employees[2] = ccc;

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(INPUT_PATH))) {
            objectOutputStream.writeObject(employees);
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(INPUT_PATH))) {
            Employee[] readObject = (Employee[]) objectInputStream.readObject();
            readObject[0].raiseSalary(10);

            for (Employee employee : readObject) {
                System.out.println("employee = " + employee);
            }
        }
    }
}
