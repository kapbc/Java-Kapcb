package com.kapcb.ccc.util;

import java.io.File;

/**
 * <a>Title: FileDeleteUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/19-16:36
 */
public class FileDeleteUtil {

    private FileDeleteUtil() {
    }

    /**
     * 删除版本落后的文件
     *
     * @param file File
     */
    public static void deleteTheOverVersionFiles(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                deleteTheOverVersionFiles(f);
            }
            if (f.isFile()) {
                if (f.getName().startsWith(".#")) {
                    System.out.println(f.getName());
                    f.delete();
                }
            }
        }
    }
}
