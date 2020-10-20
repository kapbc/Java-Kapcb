package com.kapcb.ccc.game;

/**
 * <a>Title:Attack</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/20 20:15
 */
public class Attack {

    public static final String KILL_SELF = "自杀了!!!";
    public static final String BEAT = "打败了";
    public static final String NO_MONEY = "经费不足，不打了";

    private Attack() {
    }

    public static String getAttackByMonster(Monster monster, Ultraman ultraman) {
        if (!monster.getLive()) {
            return monster.getName() + KILL_SELF;
        } else if (!ultraman.getLive()) {
            return monster.getName() + BEAT + ultraman.getName();
        } else if (monster == null || ultraman == null) {
            return NO_MONEY;
        }

        Long cal = getCal(monster.getAttack(), ultraman.getDefense());
        if (cal >= 0) {
            ultraman.setDefense(cal);
            return monster.getName() + "攻击了" + ultraman.getName() + "造成了:" + monster.getAttack() + "点伤害,剩余防御力为:" + ultraman.getDefense();
        } else {
            ultraman.setLive(false);
            return monster.getName() + "打败了" + ultraman.getName() + ",造成了:" + monster.getAttack() + "点伤害!!!";
        }
    }

    public static String getAttackByUltraman(Ultraman ultraman, Monster monster) {
        if (!ultraman.getLive()) {
            return ultraman.getName() + KILL_SELF;
        } else if (!monster.getLive()) {
            return ultraman.getName() + BEAT + monster.getName();
        } else if (ultraman == null || monster == null) {
            return NO_MONEY;
        }

        Long cal = getCal(ultraman.getAttack(), monster.getDefense());
        if (cal >= 0) {
            monster.setDefense(cal);
            return ultraman.getName() + "攻击了" + monster.getName() + "造成了:" + ultraman.getAttack() + "点伤害,剩余防御力为:" + monster.getDefense();
        } else {
            monster.setLive(false);
            return ultraman.getName() + "打败了" + monster.getName() + ",造成了:" + ultraman.getAttack() + "点伤害!!!";
        }
    }

    private static Long getCal(Long attack, Long defense) {
        return defense - attack;
    }
}
