package com.kapcb.ccc.pattern.strategy;

/**
 * <a>Title: CouponStrategy </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-14:43
 */
public class CouponStrategy implements PromotionStrategy{


    @Override
    public void doPromotion() {
        System.out.println("领取优惠卷，课程的价格直接减优惠卷面值抵扣");
    }
}
