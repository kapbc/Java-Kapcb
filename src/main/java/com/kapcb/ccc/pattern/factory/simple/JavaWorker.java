package com.kapcb.ccc.pattern.factory.simple;

/**
 * <a>Title:CoderWorker</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 23:58
 */
public class JavaWorker implements IWork {

    @Override
    public void work() {
        System.out.println("我是Java程序员");
    }
}
