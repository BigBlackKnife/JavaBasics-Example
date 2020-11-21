package com.generics.erasure_generice;

import java.util.ArrayList;

/**
 * @author Blaife
 * @description 泛型擦除
 * @date 2020/11/21 19:38
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
