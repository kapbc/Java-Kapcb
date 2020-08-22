package com.kapcb.ccc.pattern.factory.afp;

/**
 * <a>Title:PythonVideo</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:25
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制Python视频");
    }
}
