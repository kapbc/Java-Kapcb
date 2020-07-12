package com.kapcb.ccc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * <a>Title:ChannelDemo02</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/12 22:32
 */
public class ChannelDemo02 {
    /**
     * 通道完成数据传输
     *
     * @param args args...
     */
    public static void main(String[] args) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("D:\\pppp.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("D:\\2222.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

            //读取通道，需要读取数据到outChannel
            //inChannel.transferTo(0, inChannel.size(), outChannel);

            //输出通道，从inChannel中读取数据
            outChannel.transferFrom(inChannel,0,inChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
