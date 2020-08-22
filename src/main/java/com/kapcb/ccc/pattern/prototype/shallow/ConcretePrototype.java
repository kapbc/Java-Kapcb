package com.kapcb.ccc.pattern.prototype.shallow;

import java.util.List;

/**
 * <a>Title:ConcretePrototype</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:37
 */
public class ConcretePrototype implements ProtoType {
    private String name;
    private String email;
    private List hobbies;

    public ConcretePrototype(){}

    public ConcretePrototype(String name, String email, List hobbies) {
        this.name = name;
        this.email = email;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public ProtoType clone() {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setEmail(this.email);
        concretePrototype.setName(this.name);
        concretePrototype.setHobbies(this.hobbies);
        return concretePrototype;
    }
}
