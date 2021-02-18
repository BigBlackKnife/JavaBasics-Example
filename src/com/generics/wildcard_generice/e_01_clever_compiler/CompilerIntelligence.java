package com.generics.wildcard_generice.e_01_clever_compiler;


import java.util.Arrays;
import java.util.List;

/**
 * @author Blaife
 * @description 被阻止去调用任何接收参数的方法？
 * @date 2021/2/18 22:18
 */

class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

public class CompilerIntelligence {

    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        flist.contains(new Apple());
        flist.indexOf(new Apple());

        // 以上程序可以正常执行， 这是否意味着编译器将检查代码
        // 以查看是否有某个特定的方法修改了他的对象

        // 并非如此

        // flist.add(new Apple()); // capture of ? extends Fruit

        // 编译器会直接拒绝对阐述列表中涉及通配符的方法（例如add()）的调用
        // contains和indexOf参数类型都是Object，所以编译器允许

        // 意味着由泛型类的设计者来决定哪些调用时安全的
    }

}
