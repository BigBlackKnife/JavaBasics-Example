package com.enumerated.unit11multichanneldistribution.ele02constantdistribution;

import com.enumerated.unit11multichanneldistribution.Outcome;
import com.enumerated.unit11multichanneldistribution.ele01enumdistribution.Competitor;
import com.enumerated.unit11multichanneldistribution.ele01enumdistribution.RoShamBo;

/**
 * 使用常量相关方法实现 -- 多路分发
 * 我们可以为每个enum实例提供方法的不同实现，但它们并不是类型，不能作为方法签名中的类型来使用
 * 将enum用在switch语句中使用
 *
 * 依旧使用了Competitor和RoShamBo， 可以工作，但并不合理，因为在RoShamBo2中添加一个新的类型是，只需要更少的代码
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {

    PAPER {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return Outcome.DRAW;
                case SCISSORS:
                    return Outcome.LOSE;
                case POCK:
                    return Outcome.WIN;
            }
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return Outcome.WIN;
                case SCISSORS:
                    return Outcome.DRAW;
                case POCK:
                    return Outcome.LOSE;
            }
        }
    },
    POCK {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return Outcome.LOSE;
                case SCISSORS:
                    return Outcome.WIN;
                case POCK:
                    return Outcome.DRAW;
            }
        }
    }
    ;

    @Override
    public abstract Outcome compete(RoShamBo3 it);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
