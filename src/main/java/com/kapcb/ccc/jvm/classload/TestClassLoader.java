package com.kapcb.ccc.jvm.classload;

import sun.misc.Launcher;

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

    private static final String EXT_URL = "java.ext.dirs";
    private static final String SEMICOLON = ";";

    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        Arrays.stream(urLs).forEach(System.out::println);

        // 从上面的路劲中随便挑选一个类, 查看其类加载器 :
        ClassLoader proxyClassClassLoader = Proxy.class.getClassLoader();
        // null --> BootStrap Class Loader
        System.out.println("proxyClassClassLoader = " + proxyClassClassLoader);

        System.out.println("===========extension class loader spilt line===========");
        String extensionUrl = System.getProperty(EXT_URL);
        Arrays.stream(extensionUrl.split(SEMICOLON)).forEach(System.out::println);

    }

}
