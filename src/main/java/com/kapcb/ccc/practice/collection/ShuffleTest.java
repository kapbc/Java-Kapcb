package com.kapcb.ccc.practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a>Title: ShuffleTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-14:33
 */
public class ShuffleTest {

    public static void main(String[] args) {
        String[] pokerNumber = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] Decor = new String[]{"♣", "♦", "♥", "♠"};
        List<String> list = new ArrayList<>();
        for (String decor : Decor) {
            for (String number : pokerNumber) {
                list.add(decor + number);
            }
        }
        list.add("BigKing");
        list.add("SmallKing");
        Collections.shuffle(list);

        List<String> liudehua = new ArrayList<>();
        List<String> kapcb = new ArrayList<>();
        List<String> zhourunfa = new ArrayList<>();
        List<String> dipai = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i >= 51) {
                dipai.add(list.get(i));
                continue;
            }
            if (i % 3 == 0) {
                liudehua.add(list.get(i));
                continue;
            }
            if (i % 3 == 1) {
                kapcb.add(list.get(i));
                continue;
            }
            if (i % 3 == 2) {
                zhourunfa.add(list.get(i));
                continue;
            }
        }

        System.out.println("刘德华的牌：" + liudehua);
        System.out.println("kapcb的牌：" + kapcb);
        System.out.println("周润发的牌：" + zhourunfa);
        System.out.println("底牌：" + dipai);
    }
}
