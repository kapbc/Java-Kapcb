package com.kapcb.ccc.practice.stream.optional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * <a>Title: OptionalTestBean </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11-11:08
 */
public class OptionalTestBean {

    private Integer id;
    private String name;
    private LocalDateTime birthday;
    private Integer age;

    /**
     * I Hope My Project Won't Tips Too Many Objects That I Don't Want To Use When I Am Coding!
     */
    private OptionalTestBean() {
    }

    public OptionalTestBean(Integer id, String name, LocalDateTime birthday, Integer age) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    public static Optional<OptionalTestBean> lookup(OptionalTestBean optionalTestBean) {
        return Integer.valueOf(1234).equals(optionalTestBean.getId()) ? Optional.empty() : Optional.of(optionalTestBean);
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
