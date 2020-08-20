package com.kapcb.ccc.pattern.factory.simple;

/**
 * <a>Title:WorkFactory</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/21 0:01
 */
public class WorkFactory {
    private static final String JAVA_WORKER = "Java";
    private static final String PYTHON_WORKER = "Python";

    public IWork create(String name) {
        if (JAVA_WORKER.equals(name)) {
            return new JavaWorker();
        } else if (PYTHON_WORKER.equals(name)) {
            return new PythonWorker();
        } else {
            return null;
        }
    }
}
