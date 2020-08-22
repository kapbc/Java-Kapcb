package com.kapcb.ccc.pattern.factory.simple;

/**
 * <a>Title:SimpleMain</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/20 23:59
 */
public class SimpleMain {
    public static void main(String[] args) {
        /*JavaWorker coderWorker = new JavaWorker();
        coderWorker.work();*/

        /*WorkFactory workFactory = new WorkFactory();
        IWork iWork = workFactory.create("com.kapcb.ccc.pattern.factory.simple.JavaWorker");
        iWork.work();*/

        WorkFactory workFactory = new WorkFactory();
        IWork iWork = workFactory.create(JavaWorker.class);
        iWork.work();
    }
}
