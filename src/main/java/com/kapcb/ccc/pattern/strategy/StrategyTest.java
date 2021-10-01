package com.kapcb.ccc.pattern.strategy;

/**
 * <a>Title: StrategyTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-14:48
 */
public class StrategyTest {

    public static void main(String[] args) {
        PromotionActivity couponActivity = new PromotionActivity(new CouponStrategy());
        PromotionActivity cashbackActivity = new PromotionActivity(new CashbackStrategy());

        couponActivity.execute();
        cashbackActivity.execute();
        
        String promotionKey = "COUPON";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }
}
