package com.generics.simple_generice.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Blaife
 * @description RandomList - 持有特定类型对象的列表
 * @date 2020/10/6 23:55
 */
public class RandomList<T> extends ArrayList<T> {

    private Random rand = new Random(47);

    public T select() {
        return get(rand.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        Arrays.stream("The quick brown fox jumped over the lazy brown dog".split(" ")).forEach(rs::add);
        IntStream.range(0, 11).forEach(i -> System.out.print(rs.select() + " "));
    }

}
