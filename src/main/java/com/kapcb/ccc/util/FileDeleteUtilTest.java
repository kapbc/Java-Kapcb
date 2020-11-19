package com.kapcb.ccc.util;

import java.io.File;

/**
 * <a>Title: FileDeleteUtilTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/19-16:42
 */
public class FileDeleteUtilTest {

    public static void main(String[] args) {
        String path = "#{yuorFilePath}";
        File file = new File(path);
        FileDeleteUtil.deleteTheOverVersionFiles(file);
    }
}
