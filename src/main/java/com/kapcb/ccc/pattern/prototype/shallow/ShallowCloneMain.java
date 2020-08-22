package com.kapcb.ccc.pattern.prototype.shallow;

import java.util.ArrayList;

/**
 * <a>Title:ShallowCloneMain</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:43
 */
public class ShallowCloneMain {
    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype("kapcb", "123456@qq.com", new ArrayList<String>());
        Client client = new Client(concretePrototype);
        ConcretePrototype concretePrototypeClone = (ConcretePrototype) client.startClone(concretePrototype);
        System.out.println("concretePrototypeClone = " + concretePrototypeClone);
        System.out.println("原对象中的引用类型的地址值" + concretePrototype.getHobbies());
        System.out.println("克隆对象中引用类型的地址值" + concretePrototypeClone.getHobbies());
        System.out.println(concretePrototype.getHobbies() == concretePrototypeClone.getHobbies());
    }
}
