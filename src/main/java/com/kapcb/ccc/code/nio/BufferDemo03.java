package com.kapcb.ccc.code.nio;

import java.nio.ByteBuffer;

/**
 * <a>Title:BufferDemo03</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/12 21:05
 */
public class BufferDemo03 {

    public static final int CAPACITY=1024;

    public static void main(String[] args) {
        //直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(CAPACITY);

        //判断是否为直接缓冲区
        System.out.println(byteBuffer.isDirect());
    }
}
