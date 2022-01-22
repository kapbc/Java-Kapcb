package com.kapcb.ccc.jvm.classload;

/**
 * <a>Title: CustomClassLoader </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CustomClassLoader <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/22 22:48
 * @since 1.0
 */
public class CustomClassLoader {

    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("systemClassLoader = " + systemClassLoader);

        // 获取其上层即扩展类加载器
        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        // sun.misc.Launcher$ExtClassLoader@1b6d3586
        System.out.println("extensionClassLoader = " + extensionClassLoader);

        // 试图获取 BootStrap Class Loader
        ClassLoader bootStrapClassLoader = extensionClassLoader.getParent();
        // null
        System.out.println("bootStrapClassLoader = " + bootStrapClassLoader);

        // 获取用户自定义类使用的类加载器
        ClassLoader classLoader = CustomClassLoader.class.getClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("classLoader = " + classLoader);

        ClassLoader stringClassLoader = String.class.getClassLoader();
        // null
        System.out.println("stringClassLoader = " + stringClassLoader);

    }

}
