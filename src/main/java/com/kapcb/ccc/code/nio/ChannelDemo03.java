package com.kapcb.ccc.code.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <a>Title:ChannelDemo03</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/12 22:57
 */
public class ChannelDemo03 {
    public static final int CAPACITY = 10;

    /**
     * 通道之间完成数据传递，分散聚集
     *
     * @param args args...
     */
    public static void main(String[] args) {

        RandomAccessFile randomAccessFile = null;
        FileChannel channel = null;

        try {
            randomAccessFile = new RandomAccessFile("D:\\test.txt", "rw");

            //获取通道
            channel = randomAccessFile.getChannel();

            //分配指定大小的缓冲区
            ByteBuffer allocate1 = ByteBuffer.allocate(CAPACITY);
            ByteBuffer allocate2 = ByteBuffer.allocate(CAPACITY);
            ByteBuffer allocate3 = ByteBuffer.allocate(CAPACITY);

            //分散读取
            ByteBuffer[] byteBuffers = {allocate1, allocate2, allocate3};
            channel.read(byteBuffers);

            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.flip();
            }

            System.out.println(new String(byteBuffers[0].array(), 0, byteBuffers[0].limit()));
            System.out.println("=====================================================================================");
            System.out.println(new String(byteBuffers[1].array(), 0, byteBuffers[1].limit()));
            System.out.println("=====================================================================================");
            System.out.println(new String(byteBuffers[2].array(), 0, byteBuffers[2].limit()));

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (channel!=null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (randomAccessFile!=null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
