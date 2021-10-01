package com.kapcb.ccc.code.think;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname FinalaRGUMENTS
 * @date 2020/10/27 13:26
 */
public class FinalArguments {

    public void with(final Gizmo gizmo) {
        // gizmo = new Gizmo(); Illegal -- gizmo is final
    }

    public void without(Gizmo gizmo) {
        gizmo = new Gizmo();
        gizmo.spin();
    }

    public void add(final int i) {
        // i++; Can not change , i is final
    }

    public int addOne(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments finalArguments = new FinalArguments();
        finalArguments.without(null);
        finalArguments.with(null);
    }
}
