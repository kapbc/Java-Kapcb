package com.kapcb.ccc.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * <a>Title:NonBlockingNIO</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/18 20:40
 */
public class NonBlockingClient {

    private static final int CAPACITY = 1024;

    public static void main(String[] args) throws IOException {

        //1. 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        //2. 切换成非阻塞模式
        socketChannel.configureBlocking(false);

        //3. 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String next = scanner.next();
            //4. 发送数据给服务端
            byteBuffer.put((new Date().toString() + "\n" + next).getBytes());

            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //5. 关闭通道
        socketChannel.close();
    }
}
