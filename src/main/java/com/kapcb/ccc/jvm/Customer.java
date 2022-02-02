package com.kapcb.ccc.jvm;

/**
 * <a>Title: Customer </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Customer <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/2 14:57
 * @since 1.0
 */
public class Customer {

    private Integer id = 100001;

    private String name;

    private Account account;

    {
        name = "kapcd";
    }

    public Customer() {
        account = new Account();
    }

    public static void main(String[] args) {
        Customer customer = new Customer();





    }

}
