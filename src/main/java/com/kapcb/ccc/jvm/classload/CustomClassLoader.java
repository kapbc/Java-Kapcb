package com.kapcb.ccc.jvm.classload;

import java.io.FileNotFoundException;

/**
 * <a>Title: CustomClassLoader </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CustomClassLoader <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/23 0:01
 * @since 1.0
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classFromCustomPath = getClassFromCustomPath("");
            if (classFromCustomPath == null) {
                throw new FileNotFoundException();
            } else {
                return super.defineClass(name, classFromCustomPath, 0, classFromCustomPath.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        throw new ClassNotFoundException();
    }

    private static byte[] getClassFromCustomPath(String classPathPrefix) {
        if (classPathPrefix == null || "".equals(classPathPrefix)) {
            return null;
        }
        ""
    }

}
