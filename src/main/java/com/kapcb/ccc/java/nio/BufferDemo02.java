package com.kapcb.ccc.java.nio;

import java.nio.ByteBuffer;

/**
 * <a>Title:BufferDemo02</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/10 22:43
 */
public class BufferDemo02 {
    public static final String DEMO = "abcd";

    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put(DEMO.getBytes());
        allocate.flip();
        byte[] bytes = new byte[allocate.limit()];
        allocate.get(bytes,0,2);
        System.out.println(new String(bytes,0,2));
        System.out.println(allocate.position());

        //mark标记
        allocate.mark();

        allocate.get(bytes,2,2);

        System.out.println(new String(bytes, 2, 2));
        System.out.println(allocate.position());

        //恢复到mark的位置
        allocate.reset();
        System.out.println(allocate.position());

        //判断缓冲区中是否有数据，如果有显示有多少个
        if (allocate.hasRemaining()) {
            System.out.println(allocate.position());
        }
    }
}
