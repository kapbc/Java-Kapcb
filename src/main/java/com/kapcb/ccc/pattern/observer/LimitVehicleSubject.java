package com.kapcb.ccc.pattern.observer;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

/**
 * <a>Title: LimitVehicleSubject </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/3 22:31
 */
public class LimitVehicleSubject implements Subject {

    private static final Logger log = Logger.getLogger(String.valueOf(LimitVehicleSubject.class));

    // 定义观察者集合
    private Set<Observer> RED_LAMP_OBSERVER;
    // 定义周几
    private Integer day;

    public LimitVehicleSubject() {
        RED_LAMP_OBSERVER = new HashSet<>();
    }

    public void setDate(Integer day) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("day only limit in 1 ~ 7");
        }
        this.day = day;
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
