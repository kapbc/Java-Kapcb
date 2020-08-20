package com.kapcb.ccc.pattern.singleton.inner;

import java.lang.reflect.Constructor;

/**
 * <a>Title:LazyInnerClassSingletonTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * 反射破坏单例模式
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 22:41
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
        try {
            /**
             * 获取类
             */
            Class<?> clazz = LazyInnerClassSingleton.class;
            /**
             * 通过反射获取私有无参构造器
             */
            Constructor<?> constructor = clazz.getDeclaredConstructor(null);
            /**
             * 强制访问
             */
            constructor.setAccessible(true);
            /**
             * 强制实例化对象
             */
            Object instance1 = constructor.newInstance();
            Object instance2 = constructor.newInstance();

            System.out.println(instance1 == instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
