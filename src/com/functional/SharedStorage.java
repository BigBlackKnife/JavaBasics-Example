package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * @author Blaife
 * @description 闭包  使用函数作用域以外的变量
 * @data 2020/8/8 9:37
 */
class Closure1  {
    int i;
    IntSupplier makeFun (int x) {
        // 共享i 的存储空间
        return () -> x + i++;
    }
}

class Closure2  {
    IntSupplier makeFun (int x) {
        int i = 0;
        // makeFun() 完成时 i 就消失
        return () -> x + i;
    }
}

class Closure3 {
    IntSupplier makeFun(int x) {
        int i = 0;
        // x++ 和 i++ 都会报错：
        // 被 Lambda 表达式引用的局部变量必须是 final 或者是等同 final 效果的。
        // return () -> x++ + i++;
        return null;
    }
}

class Closure4 {
    // 如果使用 final 修饰 x和 i，就不能再递增它们的值了
    IntSupplier makeFun(final int x) {
        final int i = 0;
        return () -> x + i;
    }
}

class Closure5 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        // Variable used in lambda expression should be final or effectively final
        // return () -> x + i;
        return null;
    }
}

class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        final int iFinal = i;
        final int xFinal = x;
        return () -> xFinal + iFinal;
    }
}

class Closure7 {
    // 无法编译成功
    IntSupplier makeFun(int x) {
        Integer i = 0;
        i = i + 1;
        // return () -> x + i;
        return null;
    }
}

class Closure8 {
    Supplier<List<Integer>> makeFun() {
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }
    public static void main(String[] args) {
        Closure8 c7 = new Closure8();
        List<Integer>
                l1 = c7.makeFun().get(),
                l2 = c7.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);
    }
}

public class SharedStorage {
    public static void main(String[] args) {

        Closure1 c1 = new Closure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
    }
}