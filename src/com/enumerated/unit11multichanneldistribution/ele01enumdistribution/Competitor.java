package com.enumerated.unit11multichanneldistribution.ele01enumdistribution;

import com.enumerated.unit11multichanneldistribution.Outcome;

/**
 * 比较输赢的接口方法，为了组织子类
 * @param <T>
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}