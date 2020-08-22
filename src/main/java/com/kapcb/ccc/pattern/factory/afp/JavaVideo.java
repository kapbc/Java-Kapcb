package com.kapcb.ccc.pattern.factory.afp;

/**
 * <a>Title:JavaVideo</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:22
 */
public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制Java视频");
    }
}
