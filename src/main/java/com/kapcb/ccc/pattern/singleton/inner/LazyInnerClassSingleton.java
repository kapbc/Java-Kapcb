package com.kapcb.ccc.pattern.singleton.inner;

/**
 * <a>Title:LazyInnerClassSingleton</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * 单例模式：静态内部类
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 22:34
 */
public class LazyInnerClassSingleton {
    /**
     * 这种形式兼顾饿汉式单例模式的内存浪费问题和 synchronized 的性能问题
     * 完美的屏蔽了这两个问题的缺点
     * <p>
     * 使用 LazyInnerClassGeneral 的时候，默认会先初始化内部类
     * 如果没有使用，则不加载内部类
     */
    private LazyInnerClassSingleton() {
    }

    /**
     * static 是为了使单例的空间共享
     * final 保证这个方法不被重载、重写
     *
     * @return LazyInnerClassSingleton
     */
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
    }

    /**
     * 默认不加载
     */
    private static class LazyHolder {
        public static final LazyInnerClassSingleton LAZY_INNER_CLASS_SINGLETON = new LazyInnerClassSingleton();
    }
}

