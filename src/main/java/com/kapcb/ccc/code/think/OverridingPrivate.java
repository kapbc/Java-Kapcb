package com.kapcb.ccc.code.think;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname OverridingPrivate
 * @date 2020/10/27 13:53
 */
public class OverridingPrivate extends WithFinals{

    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}
