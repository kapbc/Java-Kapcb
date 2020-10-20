package com.kapcb.basic.monsterGame;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname MonsterGameMain
 * @description TODO
 * @date 2020/10/10 14:47
 */
public class MonsterGameMain {
    public static void main(String[] args) {
        Monster monster = new Monster("我是大怪兽", 50, 56.2, 1500L, 10000L, 1.0F, true);
        Ultraman ultraman = new Ultraman("我是奥特曼", 50, 57.0, 1550L, 8500L, 1.0F, true);

        while (monster.getLive() && ultraman.getLive()) {
            String attackByUltraman = Attack.getAttackByUltraman(ultraman, monster);
            System.out.println(attackByUltraman);
            if (monster.getLive()) {
                String attackByMonster = Attack.getAttackByMonster(monster, ultraman);
                System.out.println(attackByMonster);
            }
        }
    }
}
