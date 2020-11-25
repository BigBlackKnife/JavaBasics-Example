package com.generics.erasure_generice.actionattheboundary;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Blaife
 * @description 边界处的动作 - 泛型表示没有任何意义的事物
 * @date 2020/11/24 21:58
 */
public class ArrayMarker<T> {
    private Class<T> kind;

    public ArrayMarker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings(value = "unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMarker<String> stringMarker = new ArrayMarker<String>(String.class);
        String[] stringArray = stringMarker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }

}
