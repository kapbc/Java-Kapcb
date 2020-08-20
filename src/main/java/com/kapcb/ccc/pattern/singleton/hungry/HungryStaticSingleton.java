package com.kapcb.ccc.pattern.singleton.hungry;

/**
 * <a>Title:HungryStaticSingleton</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * 单例模式：饿汉式，静态代码块
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 20:21
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton HUNGRY_STATIC_SINGLETON;

    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }

    public static HungryStaticSingleton getInstance() {
        return HUNGRY_STATIC_SINGLETON;
    }
}
