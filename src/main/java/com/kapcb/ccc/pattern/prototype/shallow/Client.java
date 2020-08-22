package com.kapcb.ccc.pattern.prototype.shallow;

/**
 * <a>Title:Client</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:39
 */
public class Client {
    private ProtoType protoType;

    public Client(ProtoType protoType) {
        this.protoType = protoType;
    }

    public ProtoType startClone(ProtoType concretePrototype) {
        return concretePrototype.clone();
    }
}
