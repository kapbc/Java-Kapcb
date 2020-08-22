package com.kapcb.ccc.pattern.factory.afp;

/**
 * <a>Title:JavaNote</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:23
 */
public class JavaNote implements INote {
    @Override
    public void write() {
        System.out.println("Java笔记");
    }
}
