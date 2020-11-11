package com.generics.simple_generice.tuple;

/**
 * @author Blaife
 * @description 元组5
 * @date 2020/11/11 19:44
 */
public class Tuple5<A, B, C, D, E>
        extends Tuple4<A, B, C, D> {
    public final E a5;
    public Tuple5(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        a5 = e;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a5;
    }
}