package com.kapcb.ccc.test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <a>Title: ComparableTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/19 - 17:05
 */
public class ComparableTest {

    1
    1
    1
    1
    1
    public static void main(String[] args) {
        Student[] students = {
                new Student("liusan", 20, 90.0F),
                new Student("lisi", 22, 90.0F),
                new Student("wangwu", 20, 99.0F),
                new Student("aaaa", 21, 91.0F)};

        Arrays.sort(students);

        Stream.of(students).forEach(System.out::println);
    }


    private static class Student implements Comparable<Student> {
        private String name;
        private int age;
        private float score;

        public Student() {
        }

        public Student(String name, int age, float score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public int compareTo(Student student) {
            float v = this.score - student.score;
            if (v == 0F) {
                return this.getAge() - student.getAge();
            }
            return (int) v;
        }

        @Override
        public String toString() {
            return "Student:[name=" + this.name + ", age= " + this.age + ", score= " + this.score + "]";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }
    }
}
