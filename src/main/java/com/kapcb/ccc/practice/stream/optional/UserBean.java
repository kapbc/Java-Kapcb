package com.kapcb.ccc.practice.stream.optional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * <a>Title: UserBean </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11-11:08
 */
public class UserBean {

    private Integer id;
    private String name;
    private LocalDateTime birthday;
    private Integer age;

    public UserBean() {
    }

    public UserBean(Integer id, String name, LocalDateTime birthday, Integer age) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    public static Optional<UserBean> lookup(UserBean userBean) {
        return Integer.valueOf(1234).equals(userBean.getId()) ? Optional.empty() : Optional.of(userBean);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBean:[ id= " + this.getId() + ", name= " + this.getName() + ", birthday= " + this.birthday + ", age= " + this.age + " ]";
    }
}
