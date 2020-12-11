package com.kapcb.ccc.java.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * <a>Title:AllocateDirectDemo</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/12 22:03
 */
public class AllocateDirectDemo {
    /**
     * 直接缓冲区完成文件复制(内存映射文件)
     *
     * @param args args...
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        /**
         * StandardOpenOption.READ:进行只读操作
         */
        try {
            inChannel = FileChannel.open(Paths.get("D:\\pppp.jpg"), StandardOpenOption.READ);
            /**
             * StandardOpenOption.CREATE_NEW:如果不存在则创建，如果存在则报错
             * StandardOpenOption.CREATE:如果不存在则创建，如果存在则覆盖
             */
            outChannel = FileChannel.open(Paths.get("D:\\1111.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

            //内存映射文件,将缓冲区建立在物理内存上
            MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接对缓冲区进行数据的读写操作
            byte[] bytes = new byte[inMappedBuffer.limit()];

            //将缓冲区中的数据从in拿到out即可
            inMappedBuffer.get(bytes);
            outMappedBuffer.put(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            long end = System.currentTimeMillis();
            System.out.println("完成复制用时：" + (end - start));
        }
    }
}
