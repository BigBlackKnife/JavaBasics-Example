package com.enumerated.unit11multichanneldistribution.ele03enummapdistribution;

import com.enumerated.unit11multichanneldistribution.Outcome;
import com.enumerated.unit11multichanneldistribution.ele01enumdistribution.Competitor;
import com.enumerated.unit11multichanneldistribution.ele01enumdistribution.RoShamBo;

import java.util.EnumMap;

/**
 * 使用EnumMap分发
 *
 * 使用EnumMap把所有可能的情况双层嵌套存储起来，比较时直接根据实例类型获取即可
 */
public enum RoShamBo5 implements Competitor<RoShamBo5> {

    PAPER, SCISSORS, ROCK;

    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table =
            new EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>(RoShamBo5.class);

    static {
        for (RoShamBo5 it : RoShamBo5.values()) {
            table.put(it, new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class));
        }

        initRow(PAPER, Outcome.DRAW, Outcome.LOSE, Outcome.WIN);
        initRow(SCISSORS, Outcome.WIN, Outcome.DRAW, Outcome.LOSE);
        initRow(ROCK, Outcome.LOSE, Outcome.WIN, Outcome.DRAW);

    }

    static void initRow(RoShamBo5 it, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER, vPAPER);
        row.put(RoShamBo5.SCISSORS, vSCISSORS);
        row.put(RoShamBo5.ROCK, vROCK);
    }

    @Override
    public Outcome compete(RoShamBo5 it) {
        // 此时进行了两次分发 分别时this和it
        return table.get(this).get(it);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 20);
    }
}
