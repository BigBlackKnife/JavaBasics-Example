package com.generics.method_generice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Blaife
 * @description 可变参数和泛型方法
 * @date 2020/11/10 22:07
 */
public class GenericVarargs {

    public static <T> List<T> makeList(T... arg) {
        List<T> result = new ArrayList<T>();
        for (T item : arg) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        System.out.println(ls);
        ls = makeList("A","B","C");
        System.out.println(ls);
        ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }

}
