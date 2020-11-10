package com.generics.method_generice;

import java.util.stream.Stream;

/**
 * @author Blaife
 * @description TODO
 * @date 2020/11/10 22:47
 */
public class BasicSupplierDemo {
    public static void main(String[] args) {
        Stream.generate(
                BasicSupplier.create(CountedObject.class))
                .limit(5)
                .forEach(System.out::println);
        System.out.println(new CountedObject());

    }
}
