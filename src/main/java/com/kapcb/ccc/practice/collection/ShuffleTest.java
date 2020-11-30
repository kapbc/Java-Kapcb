package com.kapcb.ccc.practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

/**
 * <a>Title: ShuffleTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-14:33
 * <p>
 * 数组模拟扑克牌场景
 */
public class ShuffleTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(ShuffleTest.class), "logmessage_en");

    public static void main(String[] args) {
        String[] number = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] decor = new String[]{"♣", "♥", "♠", "♦"};
        List<String> list = new ArrayList<>();
        for (String data : number) {
            for (String color : decor) {
                list.add(color + data);
            }
        }

        list.add("SmallKing");
        list.add("BigKing");
        Map<String, Integer> map = new HashMap<>(16);
        int index = list.size();
        for (String s : list) {
            map.putIfAbsent(s, index++);
        }
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

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.containsKey(o1) && map.containsKey(o2)) {
                    return map.get(o1) - (map.get(o2));
                }
                logger.warning("kapcb.element.not.exist");
                throw new NoSuchElementException();
            }
        };

        liudehua.sort(comparator);
        kapcb.sort(comparator);
        zhourunfa.sort(comparator);
        dipai.sort(comparator);

        System.out.println("刘德华的牌：" + liudehua);
        System.out.println("kapcb的牌：" + kapcb);
        System.out.println("周润发的牌：" + zhourunfa);
        System.out.println("底=====牌：" + dipai);
    }
}
