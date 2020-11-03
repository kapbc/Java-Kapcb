package com.kapcb.ccc.practice.comparator;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname LengthComparatorMain
 * @date 2020/11/3 9:27
 */
public class LengthComparatorMain {
    public static void main(String[] args) {
        String kapcb = "kapcb";
        String ccc = "ccc";
        LengthComparator lengthComparator = new LengthComparator();
        int compare = lengthComparator.compare(kapcb, ccc);
        if (compare > 0) {
            compare = 1;
        } else if (compare < 0) {
            compare = -1;
        }
        switch (compare) {
            case 1:
                System.out.println(kapcb + " 的长度大于 " + ccc);
                break;
            case -1:
                System.out.println(kapcb + " 的长度小于 " + ccc);
                break;
            case 0:
                System.out.println(kapcb + " 的长度相等 " + ccc);
            default:
                System.out.println("无法比较");
                break;
        }
    }
}
