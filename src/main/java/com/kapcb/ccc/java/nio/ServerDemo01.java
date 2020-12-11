package com.kapcb.ccc.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * <a>Title:ServerDemo01</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/14 22:45
 */
public class ServerDemo01 {

    public static final int CAPACITY = 1024;

    public static void main(String[] args) {

        ServerSocketChannel channel = null;
        FileChannel fileChannel = null;
        SocketChannel socketChannel = null;

        try {

            // 1.获取服务端的通道
            channel = ServerSocketChannel.open();

            fileChannel = FileChannel.open(Paths.get("D:\\2222.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            // 2.绑定连接
            channel.bind(new InetSocketAddress(9898));

            // 3.获取客户端连接通道
            socketChannel = channel.accept();

            // 4.分配制定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY);

            // 5.接收客户端数据并保存至本地
            while (socketChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                fileChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
