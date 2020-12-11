package com.kapcb.ccc.java.nio;

import java.nio.ByteBuffer;

/**
 * <a>Title:BufferDemo</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/8 22:53
 */
public class BufferDemo {

    public static final int INITIAL_CAPACITY = 1024;
    public static final String TEST_DATE = "ABCD";

    public static void main(String[] args) {
        //1. 分配一个指定大小的缓存区
        ByteBuffer allocate = ByteBuffer.allocate(INITIAL_CAPACITY);
        System.out.println("初始缓冲区测试");
        System.out.println("当前位置:" + allocate.position());
        System.out.println("限制:" + allocate.limit());
        System.out.println("容量大小:" + allocate.capacity());

        //2. 利用put方法存入数据到缓冲区中
        allocate.put(TEST_DATE.getBytes());
        System.out.println("利用put方法存入数据到缓冲区中");
        System.out.println("当前位置:" + allocate.position());
        System.out.println("限制:" + allocate.limit());
        System.out.println("容量大小:" + allocate.capacity());

        //3. 切换到读取数据的模式
        allocate.flip();
        System.out.println("切换到读取数据的模式");
        System.out.println("当前位置:" + allocate.position());
        System.out.println("限制:" + allocate.limit());
        System.out.println("容量大小:" + allocate.capacity());

        //4. 读取缓冲区中的数据
        byte[] b = new byte[allocate.limit()];
        allocate.get(b, 0, 4);
        System.out.println("当前位置:" + allocate.position());
        System.out.println("限制:" + allocate.limit());
        System.out.println("容量大小:" + allocate.capacity());
        System.out.println(new String(b, 0, 4));

        //5. 切换到读模式，但之前的数据并没有被废弃
        allocate.rewind();
        System.out.println("当前位置:" + allocate.position());
        System.out.println("限制:" + allocate.limit());
        System.out.println("容量大小:" + allocate.capacity());

        //6. 清空缓冲区,缓冲区被清空之后之前的数据并没有被清空，只是处于一种--被遗忘状态--指针回归到原始状态
        allocate.clear();
        System.out.println((char) allocate.get());
    }
}
