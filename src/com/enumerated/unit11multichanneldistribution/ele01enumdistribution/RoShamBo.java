package com.enumerated.unit11multichanneldistribution.ele01enumdistribution;

import com.utility.enumutils.Enums;

public class RoShamBo {

    /**
     * 比较方法
     * @param a 出招1
     * @param b 出招2
     * @param <T> 泛型（当前类）
     */
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    /**
     * 开始游戏 执行此方法
     * @param rsbClass 所需要生成的枚举类
     * @param size 次数
     * @param <T>
     */
    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            // 得到随机值惊醒比较
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }
}
