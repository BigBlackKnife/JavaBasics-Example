package com.generics.method_generice;

/**
 * @author Blaife
 * @description 无参构造方法的简单类
 * @date 2020/11/10 22:47
 */
public class CountedObject {
    // 静态-共用
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject " + id;
    }
}
