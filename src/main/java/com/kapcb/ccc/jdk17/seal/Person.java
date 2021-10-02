package com.kapcb.ccc.jdk17.seal;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <a>Title: Person </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/2 10:02
 */
public sealed class Person permits Teacher, Student, Soldier {

    private static final Logger log = Logger.getLogger(String.valueOf(Person.class));

    public void run(String message) {
        log.log(Level.INFO, message);
    }
}
