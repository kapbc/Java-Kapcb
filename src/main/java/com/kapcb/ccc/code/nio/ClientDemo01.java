package com.kapcb.ccc.code.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * <a>Title:ClientDemo01</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/14 22:45
 */
public class ClientDemo01 {

    public static final int CAPACITY = 1024;

    public static void main(String[] args) {
        SocketChannel channel = null;
        FileChannel fileChannel = null;
        try {

            // 1.获取通道
            channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

            fileChannel = FileChannel.open(Paths.get("D:\\pppp.jpg"), StandardOpenOption.READ);

            // 2.分配指定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY);

            // 3.读取本地文件并发送到服务端
            if (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                channel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
