package com.kapcb.ccc.code.annotation.tdd;

import com.kapcb.ccc.code.annotation.bean.BeanValidation;
import com.kapcb.ccc.code.annotation.bean.Person;

import java.time.LocalDateTime;

/**
 * <a>Title: Test </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/15-14:15
 */
public class Test {

    public static void main(String[] args) {

        Person person = new Person();
        person.setUsername("kapcb");
        person.setPassword("123456");
        person.setAge(null);
        person.setUserId(123456L);
        person.setBirthday(LocalDateTime.now());
//        Judgement<Person> personJudgement = new Judgement<>(Person.class);
//        personJudgement.valid(person);

        new BeanValidation<>(Person.class).validate(person);

    }
}
