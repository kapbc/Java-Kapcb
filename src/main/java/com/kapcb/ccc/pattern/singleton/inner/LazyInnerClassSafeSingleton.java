package com.kapcb.ccc.pattern.singleton.inner;

/**
 * <a>Title:LazyInnerClassSafeSingleton</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * 单例模式：不会被反射破坏的懒汉式
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 22:45
 */
public class LazyInnerClassSafeSingleton {

    private LazyInnerClassSafeSingleton() {
        if (LazyHolder.LAZY_INNER_CLASS_SAFE_SINGLETON != null) {
            throw new RuntimeException("Unable to create more than one singleton case!");
        }
    }

    private static final LazyInnerClassSafeSingleton getInstance() {
        return LazyHolder.LAZY_INNER_CLASS_SAFE_SINGLETON;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSafeSingleton LAZY_INNER_CLASS_SAFE_SINGLETON = new LazyInnerClassSafeSingleton();
    }
}
