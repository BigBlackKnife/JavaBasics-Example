package com.enumerated.unit11multichanneldistribution.ele02constantdistribution;

import com.enumerated.unit11multichanneldistribution.Outcome;
import com.enumerated.unit11multichanneldistribution.ele01enumdistribution.Competitor;
import com.enumerated.unit11multichanneldistribution.ele01enumdistribution.RoShamBo;


/**
 * 具有两个参数的compete()方法，执行第二个分发。
 * 这个版的本的程序更简短，但是更加的不好理解，对于一个大型系统而言，会导致整个系统不够健壮
 *
 * 此模式对之后的扩展也不够友好
 */
public enum  RoShamBo4 implements Competitor<RoShamBo4> {
    // 在每个实例中重写Competitor的方法就不需要再外部定义了
    ROCK {
        @Override
        public Outcome compete(RoShamBo4 it) {
            // 使用此方法是将与自身不用的值及自身传递。在方法中进行三元运算发判断
            return compete(SCISSORS, it);
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo4 it) {
            return compete(PAPER, it);
        }
    },
    PAPER {
        @Override
        public Outcome compete(RoShamBo4 it) {
            return compete(ROCK, it);
        }
    };

    /**
     * 比较方法，执行第二次分发
     *
     * 对当前方法而言，一共三个不同实例，方法参数传递对手实例及另一个未知实例
     * 判断时只需要判断当前实例与这两个的比较即可确定输赢
     *
     * @param loser 与自身比较会输的值
     * @param opponent 自身
     * @return
     */
    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return ((opponent == this) ? Outcome.DRAW : ((opponent == loser) ? Outcome.WIN : Outcome.LOSE));
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
