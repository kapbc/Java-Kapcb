package com.kapcb.ccc.jvm.classload;

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

    private static final String ALL_PACKAGE_NAME = "com.kapcb.ccc.jvm.classload.Log";
    private static final String LOG_CLASS_PATH = "D:/DevelopTools/IDEA/IDEA-workspace/Java-Kapcb/out/production/Java-Kapcb/com/kapcb/ccc/jvm/classload/Log.class";


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CustomClassLoader customClassLoader = new CustomClassLoader(LOG_CLASS_PATH);

        Class<?> LogClass = customClassLoader.loadClass(ALL_PACKAGE_NAME);

        ClassLoader classLoader = LogClass.getClassLoader();
        System.out.println("Log 类的类加载器是 : [ " + classLoader + " ]");

        Method mainMethod = LogClass.getDeclaredMethod("main", String[].class);
        Object object = LogClass.newInstance();
        String[] strings = new String["ad"];
        mainMethod.invoke(object,args)

    }


}
