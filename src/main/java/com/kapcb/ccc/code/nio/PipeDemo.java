package com.kapcb.ccc.code.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * <a>Title:PipeDemo</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/18 22:20
 */
public class PipeDemo {
    public static final int CAPACITY = 1024;

    public static void main(String[] args) throws IOException {
        //1. 获取管道
        Pipe pipe = Pipe.open();

        //2. 将缓冲区中的数据写入管道中
        ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY);

        Pipe.SinkChannel sinkChannel = pipe.sink();
        byteBuffer.put("通过单向通道发送数据！".getBytes());
        byteBuffer.flip();
        sinkChannel.write(byteBuffer);

        //3. 读取缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        byteBuffer.flip();
        int len = sourceChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array(), 0, len));

        //关闭管道
        sourceChannel.close();
        sinkChannel.close();
    }
}
