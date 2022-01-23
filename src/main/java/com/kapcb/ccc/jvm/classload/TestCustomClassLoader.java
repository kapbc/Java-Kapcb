package com.kapcb.ccc.jvm.classload;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <a>Title: TestCustomClassLoader </a>
 * <a>Author: Kapcb <a>
 * <a>Description: TestCustomClassLoader <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/23 14:53
 * @since 1.0
 */
public class TestCustomClassLoader {

    // Log 类的全类名
    private static final String ALL_PACKAGE_NAME = "com.kapcb.ccc.jvm.classload.Log";
    // Log 类的 class 文件路径
    private static final String LOG_CLASS_PATH = "D:/DevelopTools/IDEA/IDEA-workspace/Java-Kapcb/out/production/Java-Kapcb/com/kapcb/ccc/jvm/classload/Log.class";


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        CustomClassLoader customClassLoader = new CustomClassLoader(LOG_CLASS_PATH);

        Class<?> LogClass = customClassLoader.loadClass(ALL_PACKAGE_NAME);

        ClassLoader classLoader = LogClass.getClassLoader();
        System.out.println("Log 类的类加载器是 : [ " + classLoader + " ]");

        // 获取 Log 类中的 main 方法
        Method mainMethod = LogClass.getDeclaredMethod("main", String[].class);
        // 实例化 Log 类
        Object object = LogClass.newInstance();
        // 随便传入一个参数
        String[] arg = new String[]{"ad"};
        // 反射激活 Log 类中的 main 方法
        mainMethod.invoke(object, (Object) arg);
    }

}
