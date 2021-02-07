package com.kapcb.ccc.pattern.strategy;

/**
 * <a>Title: GroupBuyStrategy </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-14:45
 */
public class GroupBuyStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价");
    }
}
