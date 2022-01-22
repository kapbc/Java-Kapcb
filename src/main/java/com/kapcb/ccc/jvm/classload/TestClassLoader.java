package com.kapcb.ccc.jvm.classload;

import sun.misc.Launcher;
import sun.security.ec.ECKeyFactory;

import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;

/**
 * <a>Title: TestClassLoader </a>
 * <a>Author: Kapcb <a>
 * <a>Description: TestClassLoader <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/22 23:28
 * @since 1.0
 */
public class TestClassLoader {

    private static final String SEMICOLON = ";";
    private static final String EXT_URL = "java.ext.dirs";

    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        Arrays.stream(urLs).forEach(System.out::println);
        System.out.println("\n");

        // 从上面的路劲中随便挑选一个类, 查看其类加载器 :
        ClassLoader proxyClassClassLoader = Proxy.class.getClassLoader();
        // null --> BootStrap Class Loader
        System.out.println("proxyClassClassLoader = " + proxyClassClassLoader);

        System.out.println("\n");
        System.out.println("===========extension class loader spilt line===========");

        // 寻找 jre/lib/ext 目录下的 class 获取 ClassLoader
        ClassLoader ecKeyFactoryClassLoader = ECKeyFactory.class.getClassLoader();
        // sun.misc.Launcher$ExtClassLoader@7cca494b
        System.out.println("ecKeyFactoryClassLoader = " + ecKeyFactoryClassLoader);

        System.out.println("\n");
        String extensionUrl = System.getProperty(EXT_URL);
        Arrays.stream(extensionUrl.split(SEMICOLON)).forEach(System.out::println);

        // 获取自定义类的 ClassLoader
        ClassLoader classLoader = CustomClassLoader.class.getClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("classLoader = " + classLoader);
    }

}
