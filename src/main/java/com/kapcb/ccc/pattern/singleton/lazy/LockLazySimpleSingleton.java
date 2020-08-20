package com.kapcb.ccc.pattern.singleton.lazy;

/**
 * <a>Title:LockLazySimpleSingleton</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * 单例模式：懒汉式 线程安全
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 22:27
 */
public class LockLazySimpleSingleton {

    private static LockLazySimpleSingleton lockLazySimpleSingleton;

    private LockLazySimpleSingleton() {
    }

    public synchronized static LockLazySimpleSingleton getInstance() {
        if (lockLazySimpleSingleton == null) {
            lockLazySimpleSingleton = new LockLazySimpleSingleton();
        }
        return lockLazySimpleSingleton;
    }
}
