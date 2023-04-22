package com.kapcb.ccc.synchronize.queue;

/**
 * <a>Title: FairnessBoundedBlockingQueue </a>
 * <a>Author: Kapcb <a>
 * <a>Description: FairnessBoundedBlockingQueue <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/4/22 20:21
 * @since 1.0
 */
public class FairnessBoundedBlockingQueue implements IQueue {

    /**
     * 队列的容量
     */
    protected final int capacity;

    /**
     * 头指针, empty: head.next == tail == null
     */
    protected Node head;

    /**
     * 尾指针
     */
    protected Node tail;

    /**
     * 出队锁
     */
    protected final Object pollLock = new Object();

    protected int canPollCount;

    /**
     * 入队锁
     */
    protected final Object offerLock = new Object();

    protected int canOfferCount;

    protected final WaitQueue pollQueue = new WaitQueue();
    protected final WaitQueue offerQueue = new WaitQueue();

    /**
     * 构造器
     *
     * @param capacity 指定队列大小
     */
    public FairnessBoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.canOfferCount = capacity;
        this.canPollCount = 0;
        this.head = new Node(null);
        this.tail = head;
    }

    /**
     * 如果队列已满，通过返回值标识
     *
     * @param object 元素
     * @return 如果该元素已添加到此队列，则返回 true；否则返回 false
     */
    @Override
    public boolean offer(Object object) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException(); // 线程已中断，直接退出即可，防止中断线程竞争锁
        }
        WaitNode wait = null;
        synchronized (offerLock) {
            // 在有阻塞请求或者队列为空时，阻塞等待
            if (canOfferCount <= 0 || !offerQueue.isEmpty()) {
                wait = new WaitNode();
                offerQueue.enq(wait);
            } else {
                // continue.
            }
        }

        try {
            if (wait != null) {
                wait.doWait(3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            offerQueue.doNotify();
            throw e;
        }

        // 确保此时线程状态正常，以下不会校验中断
        synchronized (offerLock) {
            Node node = new Node(object);
            tail.next = node;
            tail = node;
            canOfferCount--;
        }
        synchronized (pollLock) {
            ++canPollCount;
            pollQueue.doNotify();
        }
        return true;
    }

    /**
     * 如果队列为空，head.next == null；返回空元素
     *
     * @return 如果此队列为空，则返回 null
     */
    @Override
    public Object poll() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object result = null;
        WaitNode wait = null;
        synchronized (pollLock) {
            // 在有阻塞请求或者队列为空时，阻塞等待
            if (canPollCount <= 0 || !pollQueue.isEmpty()) {
                wait = new WaitNode();
                pollQueue.enq(wait);
            } else {
                // ignore
            }
        }

        try {
            if (wait != null) {
                wait.doWait(3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            // 传递消息
            pollQueue.doNotify();
            throw e;
        }

        // 以下不会检测线程中断状态
        synchronized (pollLock) {
            result = head.next.value;
            head.next.value = 0;
            // ignore head;
            head = head.next;
            canPollCount--;
        }

        synchronized (offerLock) {
            canOfferCount++;
            offerQueue.doNotify();
        }
        return result;
    }

}

class WaitQueue {

    WaitNode head;
    WaitNode tail;

    WaitQueue() {
        head = new WaitNode();
        tail = head;
    }

    synchronized void doNotify() {
        for (; ; ) {
            WaitNode node = deq();
            if (node == null) {
                break;
            } else if (node.doNotify()) {
                // 此处确保NOTIFY成功
                break;
            } else {
                // ignore, and retry.
            }
        }
    }

    synchronized boolean isEmpty() {
        return head.next == null;
    }

    synchronized void enq(WaitNode node) {
        tail.next = node;
        tail = tail.next;
    }

    synchronized WaitNode deq() {
        if (head.next == null) {
            return null;
        }
        WaitNode res = head.next;
        head = head.next;
        if (head.next == null) {
            tail = head; // 为空，迁移tail节点
        }
        return res;
    }
}

class Node {

    Object value;

    Node next;

    Node(Object object) {
        this.value = object;
        next = null;
    }

}

class WaitNode {
    boolean released;
    WaitNode next;

    WaitNode() {
        released = false;
        next = null;
    }

    synchronized void doWait(long milliSeconds) throws InterruptedException {
        try {
            long startTime = System.currentTimeMillis();
            long toWait = milliSeconds;
            for (; ; ) {
                wait(toWait);
                if (released) {
                    return;
                }
                long now = System.currentTimeMillis();
                toWait = toWait - (now - startTime);
                if (toWait <= 0) {
                    throw new TimeoutException();
                }
            }
        } catch (InterruptedException e) {
            if (!released) {
                released = true;
                throw e;
            } else {
                // 如果已经释放信号量，此处不抛出异常；但恢复中断状态
                Thread.currentThread().interrupt();
            }
        }
    }

    synchronized boolean doNotify() {
        if (!released) {
            released = true;
            notify();
            return true;
        } else {
            return false;
        }
    }
}

class TimeoutException extends InterruptedException {

}

