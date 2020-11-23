package com.generics.erasure_generice.problemforerasure;

/**
 * @author Blaife
 * @description 擦除的问题
 * @date 2020/11/23 22:07
 */
class GenericBase<T> {
    private T element;
    public void set(T arg) {
        arg = element;
    }
    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {}

class Derived2 extends GenericBase {}

// 报错： 编译器期望得到一个原生基类
//class Derived3 extends GenericBase<?> {};

public class ErasureAndInheritance {
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);
    }
}
