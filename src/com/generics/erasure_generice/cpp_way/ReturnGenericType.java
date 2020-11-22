package com.generics.erasure_generice.cpp_way;

/**
 * @author Blaife
 * @description 如果某个类有一个返回 T 的方法，那么泛型就有所帮助
 *              因为它们之后将返回确切的类型
 * @date 2020/11/22 11:08
 */
public class ReturnGenericType<T extends HasF> {
    private T obj;

    ReturnGenericType(T x) {
        obj = x;
    }

    public T get() {
        return obj;
    }
}
