package com.kapcb.ccc.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * <a>Title:FileList</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/20 20:19
 */
public class FileList {
    public static final String PATH_NAME = "d://read.txt";
    public static final int CAPACITY_CHANNEL = 1024;

    public static void main(String[] args) {
        RandomAccessFile randomAccessFile = null;
        Set<String> treeSet = new TreeSet<>();
        FileChannel channel = null;
        String reg = "^D.*";
        String enterStr = "\n";
        try {
            randomAccessFile = new RandomAccessFile(PATH_NAME, "r");
            channel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY_CHANNEL);
            System.out.println("缓冲区的限制是" + byteBuffer.limit() + ",容量是" + byteBuffer.capacity() + ",位置是" + byteBuffer.position());
            while (channel.read(byteBuffer) != -1) {
                int position = byteBuffer.position();
                byteBuffer.clear();
                byte[] bytes = byteBuffer.array();
                String str = new String(bytes, 0, position);
                if (str.indexOf("\\\\") > 0) {
                    str = str.replaceAll("\\\\", "/");
                }
                System.out.println(str);
                String temp = str;
                int endIndex = 0;
                int fromIndex = 0;
                if ((endIndex = str.indexOf(enterStr, fromIndex)) != -1) {
                    temp = str.substring(fromIndex, endIndex);
                    System.out.println("temp = " + temp);
                    System.out.println(Pattern.matches(reg, temp));
                    if (!Pattern.matches(reg, temp)) {
                        StringBuilder stringBuilder = new StringBuilder(temp);
                        stringBuilder.insert(0, "D");
                        treeSet.add(stringBuilder.toString());
                    } else {
                        treeSet.add(temp);
                    }
                    fromIndex = endIndex + 1;
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
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
