package com.generics.simple_generice.tuple;

/**
 * @author Blaife
 * @description 元组4
 * @date 2020/11/11 19:43
 */
public class Tuple4 <A, B, C, D>
        extends Tuple3<A, B, C> {
    public final D a4;
    public Tuple4(A a, B b, C c, D d) {
        super(a, b, c);
        a4 = d;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a4;
    }
}
