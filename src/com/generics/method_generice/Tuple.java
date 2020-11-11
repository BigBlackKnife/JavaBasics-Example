package com.generics.method_generice;

import com.generics.simple_generice.tuple.Tuple2;
import com.generics.simple_generice.tuple.Tuple3;
import com.generics.simple_generice.tuple.Tuple4;
import com.generics.simple_generice.tuple.Tuple5;

/**
 * @author Blaife
 * @description 简化元组的使用
 * @date 2020/11/11 19:45
 */
public class Tuple {
    public static <A, B> Tuple2<A, B> tuple(A a, B b) {
        return new Tuple2<>(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C> tuple(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new Tuple4<>(a, b, c, d);
    }

    public static <A, B, C, D, E> Tuple5<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new Tuple5<>(a, b, c, d, e);
    }
}
