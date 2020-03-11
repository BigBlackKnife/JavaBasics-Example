package com.enumerated.unit11multichanneldistribution.ele04doubledimensionalarray;

import com.enumerated.unit11multichanneldistribution.Outcome;
import com.enumerated.unit11multichanneldistribution.ele01enumdistribution.Competitor;
import com.enumerated.unit11multichanneldistribution.ele01enumdistribution.RoShamBo;

/**
 * 二维数组实现多路分发
 *
 * enum实例中有一个固定的值， 并且可以通过ordinal(获取)，我们可以使用二位数组映射竞争结果
 */
public enum  RoShamBo6 implements Competitor<RoShamBo6> {

    PAPER, SCISSORS, ROCK;

    private static Outcome[][] table = {
        { Outcome.DRAW, Outcome.LOSE, Outcome.WIN },
        { Outcome.DRAW, Outcome.LOSE, Outcome.WIN },
        { Outcome.DRAW, Outcome.LOSE, Outcome.WIN },
    };

    @Override
    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }

}
