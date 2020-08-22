package com.kapcb.ccc.pattern.factory.method;

import com.kapcb.ccc.pattern.factory.simple.IWork;

/**
 * <a>Title:MethodFactoryMain</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:10
 */
public class MethodFactoryMain {
    public static void main(String[] args) {
        IWorkerFactory javaWorker = new JavaWorkerFactory();
        IWork iWork = javaWorker.create();
        iWork.work();
    }
}
