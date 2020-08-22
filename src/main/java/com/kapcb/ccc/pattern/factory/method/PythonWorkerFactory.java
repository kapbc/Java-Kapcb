package com.kapcb.ccc.pattern.factory.method;

import com.kapcb.ccc.pattern.factory.simple.IWork;
import com.kapcb.ccc.pattern.factory.simple.PythonWorker;

/**
 * <a>Title:PythonWorkerFactory</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:09
 */
public class PythonWorkerFactory implements IWorkerFactory {
    @Override
    public IWork create() {
        return new PythonWorker();
    }
}
