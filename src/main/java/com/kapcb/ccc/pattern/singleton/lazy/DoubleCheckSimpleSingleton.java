package com.kapcb.ccc.pattern.singleton.lazy;

/**
 * <a>Title:DoubleCheckSimpleSingleton</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * 单例模式：DCL懒汉式
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 22:29
 */
public class DoubleCheckSimpleSingleton {

    private volatile static DoubleCheckSimpleSingleton doubleCheckSimpleSingleton;

    private DoubleCheckSimpleSingleton() {
    }

    /**
     * 1、分配内存给这个对象
     * 2、初始化对象
     * 3、设置 lazy 指向分配的内存地址
     *
     * @return DoubleCheckSimpleSingleton
     */
    public static DoubleCheckSimpleSingleton getInstance() {
        if (doubleCheckSimpleSingleton == null) {
            synchronized (DoubleCheckSimpleSingleton.class) {
                doubleCheckSimpleSingleton = new DoubleCheckSimpleSingleton();
            }
        }
        return doubleCheckSimpleSingleton;
    }
}
