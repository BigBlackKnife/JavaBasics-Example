package com.generics.wildcard_generice.e_01_clever_compiler;

/**
 * @author Blaife
 * @description 设计者决定哪些操作是安全的
 * @date 2021/2/18 22:32
 */
public class Holder<T> {

    private T value;
    public Holder() {};
    public Holder(T val) {
        value = val;
    }
    public void set(T val) {
        value = val;
    }
    public T get() {
        return value;
    }
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<Apple>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        // 不能将其向上转型成Holder<Fruit>， 但可以是Holder<? extends Fruit>
        // Holder<Fruit> fruit = apple;
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();
        try {
            Orange c = (Orange) fruit.get();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println(fruit.equals(d));
    }

}
