package com.kapcb.ccc.pattern.factory.method;

import com.kapcb.ccc.pattern.factory.simple.IWork;

/**
 * <a>Title:IWorkerFactory</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:07
 */
public interface IWorkerFactory {
    /**
     * 工作
     *
     * @return IWork
     */
    IWork create();
}
