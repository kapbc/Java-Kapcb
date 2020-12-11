package com.kapcb.ccc.java.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <a>Title:ChannelDemo04</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/13 22:31
 */
public class ChannelDemo04 {

    public static final int CAPACITY = 1024;
    public static void main(String[] args) {

        RandomAccessFile randomAccessFile = null;
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile("D:\\test.txt", "rw");
            channel = randomAccessFile.getChannel();

            ByteBuffer allocate1 = ByteBuffer.allocate(CAPACITY);
            ByteBuffer allocate2 = ByteBuffer.allocate(CAPACITY);

            ByteBuffer[] byteBuffers  = {allocate1,allocate2};

            channel.write(byteBuffers);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (channel!=null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
