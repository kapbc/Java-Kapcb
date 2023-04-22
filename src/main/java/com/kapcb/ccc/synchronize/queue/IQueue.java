package com.kapcb.ccc.synchronize.queue;

/**
 * <a>Title: IQueue </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IQueue <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/4/22 20:18
 * @since 1.0
 */
public interface IQueue {

    /**
     * 将指定的元素插入此队列（将指定的元素插入此队列）
     *
     * @param object 元素
     * @return 如果该元素已添加到此队列，则返回 true；否则返回 false
     */
    boolean offer(Object object) throws InterruptedException;

    /**
     * 获取并移除此队列的头
     *
     * @return 如果此队列为空，则返回 null
     */
    Object poll() throws InterruptedException;

}
