package com.kapcb.ccc.code.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * <a>Title:NonBlockingServer02</a>
 * <a>Author：<a>
 * <a>Description：<a>
 * <p>
 * DatagramChannel
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/18 21:31
 */
public class NonBlockingServer01 {
    private static final int CAPACITY = 1024;
    public static final int TIME_OUT = 30000;

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();

        datagramChannel.configureBlocking(false);

        datagramChannel.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();

        datagramChannel.register(selector, SelectionKey.OP_READ);

        while (selector.select(TIME_OUT) > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isReadable()) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY);

                    datagramChannel.receive(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));
                    byteBuffer.clear();
                }
            }
            iterator.remove();
        }
    }
}
