package com.kapcb.ccc.pattern.observer;

import java.util.Observer;

/**
 * <a>Title: Subject </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/3 22:26
 */
public interface Subject extends Observer {

    /**
     * 注册观察者
     *
     * @param observer Observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer Observer
     */
    void removeObserver(Observer observer);
}
