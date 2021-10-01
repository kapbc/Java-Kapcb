package com.kapcb.ccc.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: PromotionStrategyFactory </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-14:54
 */
public class PromotionStrategyFactory {

    private static final int INITIAL_CAPACITY = 16;
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>(INITIAL_CAPACITY);

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK, new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY, new GroupBuyStrategy());
    }

    private static final PromotionStrategy PROMOTION_STRATEGY_NON = new EmptyStrategy();

    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        return PROMOTION_STRATEGY_MAP.getOrDefault(promotionKey, PROMOTION_STRATEGY_NON);
    }

    private interface PromotionKey {
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }
}
