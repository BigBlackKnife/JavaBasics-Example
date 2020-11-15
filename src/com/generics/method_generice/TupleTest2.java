package com.generics.method_generice;

import com.generics.simple_generice.tuple.*;

// 静态引入
import static com.generics.method_generice.Tuple.tuple;

/**
 * @author Blaife
 * @description 简化元组的使用 -- TupleTest2
 * @date 2020/11/11 19:46
 */
public class TupleTest2 {
    public static Tuple2<String, Integer> f() {
        return tuple("hi", 47);
    }

    public static Tuple2 f2() {
        return tuple("hi", 47);
    }

    public static Tuple3<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    public static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    public static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
