package com.generics.simple_generice.tuple;

/**
 * @author Blaife
 * @description 元组1
 * @date 2020/10/6 18:58
 */
public class Tuple1<A, B, C> {

    private final A a;
    private B b;
    private C c;

    public Tuple1(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Tuple1{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
}
