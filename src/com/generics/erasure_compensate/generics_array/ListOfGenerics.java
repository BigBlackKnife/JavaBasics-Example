package com.generics.erasure_compensate.generics_array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Blaife
 * @description 在任何想创建泛型数据的地方使用 `ArrayList`
 * @date 2020/12/2 22:40
 */
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();
    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
