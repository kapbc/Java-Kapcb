package com.kapcb.ccc.practice.abstractClasses;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname PersonTest
 * @date 2020/10/30 10:53
 */
public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Employee("Kapcb", 50000, 1997, 3, 11);
        people[1] = new Student("ccc", "Computer Science And Technology");
        for (Person person : people) {
            System.out.println(person.getUsername() + ", " + person.getDescription());
        }
    }
}
