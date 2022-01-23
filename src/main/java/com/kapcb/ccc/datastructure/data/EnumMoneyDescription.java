package com.kapcb.ccc.datastructure.data;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname EnumMoneyDescription
 * @date 2020/10/22 16:28
 */
public class EnumMoneyDescription {
    private EnumMoney money;

    public EnumMoneyDescription(EnumMoney money) {
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
            case HUNDRED:
                System.out.println("面值100元的人民币!");
                break;
            default:
                System.out.println("I want Money Money Money!!!");
        }
    }

    public static void main(String[] args) {
        EnumMoneyDescription fiftyValueMoney = new EnumMoneyDescription(EnumMoney.FIFTY);
        fiftyValueMoney.describe();
    }

}
