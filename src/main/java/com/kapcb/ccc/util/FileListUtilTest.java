package com.kapcb.ccc.util;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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

    public static void main(String[] args) {
        
        Date start = new Date();
        TreeMap<Integer, Set<String>> fileList = FileListUtil.getFileList("");
        Date end = new Date();
        System.out.println("Cost Time: " + (end.getTime() - start.getTime()));
        int count = 0;
        System.out.println("The Latest File List:");
        for (Map.Entry<Integer, Set<String>> integerSetEntry : fileList.entrySet()) {
            Set<String> value = integerSetEntry.getValue();
            for (String s : value) {
                count++;
                System.out.println(s);
            }
        }
        System.out.println("Total Files:" + count);
    }
    
}
