package com.kapcb.ccc.pattern.strategy;

/**
 * <a>Title: CashbackStrategy </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-14:44
 */
public class CashbackStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额转到支付宝账号");
    }
}
