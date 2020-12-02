package com.generics.erasure_compensate;

/**
 * @author Blaife
 * @description 擦除的补偿
 * @date 2020/11/28 19:32
 */
public class Erased<T> {
    private final int SIZE = 100;
    public static void f(Object arg) {

        // T的类型已经被擦除了

        // 不能从静态上下文中引用
        // if (arg instanceof T) {}
        // T var = new T();
        // T[] array = new T[SIZE];
        // T[] array = (T)new Object[SIZE];
    }
}
