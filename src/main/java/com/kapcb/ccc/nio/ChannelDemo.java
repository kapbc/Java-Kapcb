package com.kapcb.ccc.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <a>Title:ChannelDemo</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/12 21:24
 */
public class ChannelDemo {

    private static final int CAPACITY = 1024;

    /**
     * 利用通道完成文件复制
     *
     * @param args args...
     */
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fileInputStream = new FileInputStream("D:\\pppp.jpg");
            fileOutputStream = new FileOutputStream("D:\\aaaa.jpg");

            //获取通道
            inChannel = fileInputStream.getChannel();
            outChannel = fileOutputStream.getChannel();

            //分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(CAPACITY);

            //读取数据，将通道中的数据存入缓冲区中
            while (inChannel.read(buffer) != -1) {
                //写数据，将缓冲区的数据写到通道中

                //将缓冲区更换为读数据的模式
                buffer.flip();

                //将缓冲区中的数据写入到通道中
                outChannel.write(buffer);

                //清空缓冲区
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //只是进行数据读取，并不是读取之后数据就没了，所以是 ！=null判断
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

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
