package com.kapcb.ccc.data;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname EnumMoneyDescribtion
 * @description TODO
 * @date 2020/10/22 16:28
 */
public class EnumMoneyDescribtion {
    private EnumMoney money;

    public EnumMoneyDescribtion(EnumMoney money) {
        this.money = money;
    }

    public void describe() {
        switch (money) {
            case ONE:
                System.out.println("面值1元的人民币!");
                break;
            case FIVE:
                System.out.println("面值5元的人民币!");
                break;
            case TEN:
                System.out.println("面值10元的人民币!");
                break;
            case FIFTY:
                System.out.println("面值50元的人民币!");
                break;
            case HUNDRE:
                System.out.println("面值100元的人民币!");
                break;
            default:
                System.out.println("I want Money Money Money!!!");
        }
    }

    public static void main(String[] args) {
        EnumMoneyDescribtion fiftyValueMoney = new EnumMoneyDescribtion(EnumMoney.FIFTY);
        fiftyValueMoney.describe();
    }
}
