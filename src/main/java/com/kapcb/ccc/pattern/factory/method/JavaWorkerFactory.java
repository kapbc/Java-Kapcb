package com.kapcb.ccc.pattern.factory.method;

import com.kapcb.ccc.pattern.factory.simple.IWork;
import com.kapcb.ccc.pattern.factory.simple.JavaWorker;

/**
 * <a>Title:JavaWorkerFactory</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:09
 */
public class JavaWorkerFactory implements IWorkerFactory{
    @Override
    public IWork create() {
        return new JavaWorker();
    }
}
