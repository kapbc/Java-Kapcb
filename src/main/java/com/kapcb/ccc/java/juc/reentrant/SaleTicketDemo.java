package com.kapcb.ccc.java.juc.reentrant;

import com.kapcb.ccc.util.Constants;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <a>Title: SaleTicketDemo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/12 - 18:01
 */
public class SaleTicketDemo {

    private static final Logger logger = Logger.getLogger(String.valueOf(SaleTicketDemo.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        /**
         * Lambda Expression
         */
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "C").start();

        /**
         * Code Optimization
         */
        function(40, Ticket::saleTicket, ticket, "A");
        function(40, Ticket::saleTicket, ticket, "B");
        function(40, Ticket::saleTicket, ticket, "C");
    }

    /**
     * Consumer<T> Interface Function
     *
     * @param n        int loopCounts
     * @param consumer Consumer<Ticket> interface
     * @param ticket   Ticket
     * @param thread   String Thread Name
     */
    private static void function(int n, Consumer<Ticket> consumer, Ticket ticket, String thread) {
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                consumer.accept(ticket);
            }
        }, thread).start();
    }


    /**
     * 服务自治原则
     */
    private static class Ticket {

        private static volatile int ticketCounts = 30;

        private ReentrantLock lock = new ReentrantLock();

        public void saleTicket() {
            lock.lock();
            try {
                if (ticketCounts > 0) {
                    ticketCounts--;
                    System.out.println("Salesperson: " + Thread.currentThread().getName() + " have been sell a ticket, left: " + ticketCounts + " tickets!");
                }
                if (ticketCounts == 0) {
                    logger.log(Level.INFO, "Sorry, The Ticket Haven Been Sale Out!");
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
