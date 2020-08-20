package com.kapcb.ccc.pattern.hungry;

/**
 * <a>Title:HungrySingleton</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * 单例模式：饿汉式
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 19:56
 */
public class HungrySingleton {

    /**
     * 先静态，后动态
     * 先属性，后方法
     */
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }
}
