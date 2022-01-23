package com.kapcb.ccc.jvm.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    private String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classFromCustomPath = getClassFromCustomPath();
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

    /**
     * 以二进制流的方式将指定的 class 文件读取到系统中来
     * 如果指定路劲的字节码进行了加密, 则需要在此方法中进行解密操作, 解密之后将其还远为字节数组
     *
     * @return byte[]
     */
    private byte[] getClassFromCustomPath() {
        if (this.classPath == null || "".equals(this.classPath)) {
            return null;
        }

        File file = new File(this.classPath);
        if (file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

                byte[] buffer = new byte[1024];
                int size;
                while ((size = fileInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, size);
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
