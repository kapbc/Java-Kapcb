package com.kapcb.ccc.pattern.factory.afp;

/**
 * <a>Title:PythonNote</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:25
 */
public class PythonNote implements INote {
    @Override
    public void write() {
        System.out.println("Python笔记");
    }
}
