package com.kapcb.ccc.util;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * <a>Title:FileList</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/20 20:19
 */
public class FileListUtil {

    public static final int CAPACITY_CHANNEL = 1024;

    public static final String REG = "^D.*";
    public static final String ENTER_STR = "\n";
    public static final String PREFIX = "D";

    private FileListUtil() {
    }

    public static Set getFileListSort(String pathName) {
        FileChannel channel = null;
        RandomAccessFile randomAccessFile = null;
        Comparator<String> fileListStringCompare = new FileListStringCompare();
        Set<String> treeSet = new TreeSet<>(fileListStringCompare);
        try {
            randomAccessFile = new RandomAccessFile(pathName, "r");
            channel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY_CHANNEL);
            while (channel.read(byteBuffer) != -1) {
                int position = byteBuffer.position();
                byteBuffer.clear();
                byte[] bytes = byteBuffer.array();
                String str = new String(bytes, 0, position);
                if (str.indexOf("\\\\") > 0) {
                    str = str.replaceAll("\\\\", "/");
                }
                String[] split = str.split(ENTER_STR);
                for (int i = 0; i < split.length; i++) {
                    if (!split[i].startsWith(PREFIX)) {
                        split[i] = PREFIX + split[i];
                    }
                    treeSet.add(split[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return treeSet;
    }
}


