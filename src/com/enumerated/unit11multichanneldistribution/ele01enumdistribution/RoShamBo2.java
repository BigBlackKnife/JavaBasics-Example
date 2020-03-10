package com.enumerated.unit11multichanneldistribution.ele01enumdistribution;

import com.enumerated.unit11multichanneldistribution.Outcome;


import static com.enumerated.unit11multichanneldistribution.Outcome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    // 包 对应构造方法 包剪锤 所的出的胜负
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);

    // 得到对应的每一种选择
    private Outcome vPAPER, vSCISSORS, vROCK;
    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {

        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    };

    /**
     * 对应对手的出招，输出当前局输赢
     * @param competitor 对手的出招
     * @return
     */
    @Override
    public Outcome compete(RoShamBo2 competitor) {
        switch (competitor) {
            default:
            case PAPER:return vPAPER;
            case SCISSORS:return vSCISSORS;
            case ROCK:return vROCK;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
