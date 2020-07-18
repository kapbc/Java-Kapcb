package com.kapcb.ccc.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * <a>Title:NonBlockingServer</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/18 20:48
 */
public class NonBlockingServer {

    public static final int CAPACITY = 1024;

    public static void main(String[] args) throws IOException {
        //1. 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //2. 切换为非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //3. 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //4. 获取选择器
        Selector selector = Selector.open();

        //5. 将通道注册到选择器上,并指定“监听接收事件”
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6. 轮询的方式，获取选择器上已经“准备就绪”的事件
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            //7. 获取当前选择器中所有注册的"选择键（已经就绪的监听事件）"
            while (iterator.hasNext()) {
                //8. 获取准备“就绪”的事件
                SelectionKey selectionKey = iterator.next();

                //9. 判断具体是什么事件准备就绪
                if (selectionKey.isAcceptable()) {
                    //10. 若接收状态就绪，就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    //11. 切换非阻塞模式
                    socketChannel.configureBlocking(false);

                    //12. 将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    //13. 获取当前选择器上”读就绪“状态的通道
                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    //14. 读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY);

                    int len = 0;
                    while ((len = channel.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, len));
                        byteBuffer.clear();
                    }
                }
                //15. 取消选择键SelectionKey
                iterator.remove();
            }
        }
    }
}
