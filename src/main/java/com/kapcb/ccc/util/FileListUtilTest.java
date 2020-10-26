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

    /**
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\b\d
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\b\c
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\b\a
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\antlr
     * D:\Develop-Tools\IDEA-KEY\__MACOSX
     * D:\Develop-Tools\IDEA\IDEA\a\a
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\b
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\c
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\r
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\e
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\aopalliance
     * D:\Develop-Tools\IDEA\IDEA-MvnRepository\aopal
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\Aop
     * :\Develop-Tools\IDEA-KEY-2020
     * :\Develop-Tools\IDEA\IDEA-mvnRepository\ant\ant\1.6.5
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\avalon-framework
     * D:\Develop-Tools\IDEA\IDEA-mvnRepository\a\a
     * <p>
     * 在目标指定文件下创建一个文本，将以上文件路径拷贝至创建的文本中，执行程序，将会对以上文件路径进行指定规则排序
     *
     * @param args String[]
     */
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
