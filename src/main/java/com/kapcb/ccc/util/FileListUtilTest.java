package com.kapcb.ccc.util;

import java.util.Iterator;
import java.util.Set;

/**
 * <a>Title:FileListUtilTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/20 23:42
 */
public class FileListUtilTest {

    public static final String PATH_NAME = "d://read.txt";

    public static void main(String[] args) {
        Set fileListSort = FileListUtil.getFileListSort(PATH_NAME);
        Iterator iterator = fileListSort.iterator();
        System.out.println("The Latest File List:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
