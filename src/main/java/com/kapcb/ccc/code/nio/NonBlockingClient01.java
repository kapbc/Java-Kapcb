package com.kapcb.ccc.code.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * <a>Title:NonBlockingClient01</a>
 * <a>Author：<a>
 * <a>Description：<a>
 * <p>
 * DatagramChannel
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/18 21:31
 */
public class NonBlockingClient01 {

    public static final int CAPACITY = 1024;

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();

        datagramChannel.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String next = scanner.next();
            byteBuffer.put((new Date().toString() + "\n" + next).getBytes());
            byteBuffer.flip();
            datagramChannel.send(byteBuffer, new InetSocketAddress("127.0.0.1", 9898));
            byteBuffer.clear();
        }
        datagramChannel.close();
    }
}
