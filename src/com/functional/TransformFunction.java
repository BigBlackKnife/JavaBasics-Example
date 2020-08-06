package com.functional;

import java.util.function.Function;

/**
 * @author Blaife
 * @description 基于消费函数生成新函数
 * @data 2020/8/6 23:16
 */
class I {
    @Override
    public String toString() { return "I"; }
}

class O {
    @Override
    public String toString() { return "O"; }
}

public class TransformFunction {
    static Function<I,O> transform(Function<I,O> in) {
        return in.andThen(o -> {
            System.out.println(o);
            return o;
        });
    }

    public static void main(String[] args) {
        Function<I,O> f2 = transform(i -> {
            System.out.println(i);
            return new O();
        });
        O o = f2.apply(new I());
    }
}
