package com.generics.method_generice;

/**
 * @author Blaife
 * @description 泛型方法
 * @date 2020/11/8 18:42
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f("S");
        gm.f(gm);
    }

}
