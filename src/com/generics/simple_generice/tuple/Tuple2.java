package com.generics.simple_generice.tuple;

/**
 * @author Blaife
 * @description 元组 2
 * @date 2020/11/11 19:41
 */
public class Tuple2<A, B> {
    public final A a1;
    public final B a2;
    public Tuple2(A a, B b) { a1 = a; a2 = b; }
    public String rep() { return a1 + ", " + a2; }

    @Override
    public String toString() {
        return "(" + rep() + ")";
    }
}
