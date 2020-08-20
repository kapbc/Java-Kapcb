package com.kapcb.ccc.pattern.factory.simple;

/**
 * <a>Title:PythonWorker</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/21 0:05
 */
public class PythonWorker implements IWork {
    @Override
    public void work() {
        System.out.println("我是Python程序员");
    }
}
