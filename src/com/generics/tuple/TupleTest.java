package com.generics.tuple;

/**
 * @author Blaife
 * @description 元组测试
 * @date 2020/10/6 18:57
 */
public class TupleTest {

    public static void main(String[] args) {
        Tuple1<String, Integer, Double> tuple = new Tuple1<>("blaife", 23, 172.5);
        System.out.println(tuple);

        Tuple1<Integer, String, Character> tuple1 = new Tuple1<>(22, "power", 'S');
        System.out.println(tuple1);
    }

}
