package com.kapcb.ccc.practice.think;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname FinalOverridingIllusion
 * @date 2020/10/27 13:55
 */

public class FinalOverridingIllusion {

    public static void main(String[] args) {
        OverridingPrivate2 overridingPrivate2 = new OverridingPrivate2();
        overridingPrivate2.f();
        overridingPrivate2.g();

        OverridingPrivate overridingPrivate = overridingPrivate2;
        // overridingPrivate.f(); The method is private, so you can not access the method
        // overridingPrivate.g();

        WithFinals withFinals = overridingPrivate2;
        // withFinals.f();
        // withFinals.g();
    }
}
