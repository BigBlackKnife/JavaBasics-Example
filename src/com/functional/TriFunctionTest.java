package com.functional;

/**
 * 多参数函数式接口
 */
@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class TriFunctionTest {
    static int f(int i, long l, double d) { return 99; }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctionTest::f;
        System.out.println(tf.apply(1, 2123L, 2.1));
        tf = (i, l, d) -> 12;
        System.out.println(tf.apply(1, 2123L, 2.1));
    }
}