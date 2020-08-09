package com.functional;

import java.util.function.IntSupplier;

/**
 * @author Blaife
 * @description 作为闭包的内部类
 * @data 2020/8/9 13:48
 */
public class AnonymousClosure {

    IntSupplier makeFun(int x) {
        int i = 0;
        // 同样规则的应用:
        // i++; // 非等同 final 效果
        // x++; // 同上
        return new IntSupplier() {
            public int getAsInt() { return x + i; }
        };
    }

}
