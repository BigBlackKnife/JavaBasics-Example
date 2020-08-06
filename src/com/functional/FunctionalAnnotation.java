package com.functional;

import java.util.function.*;
/**
 * @author Blaife
 * @description @FunctionalInterface 注解强制执行此“函数式方法”模式
 * @data 2020/8/5 21:23
 */
@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

/*
@FunctionalInterface
interface NotFunctional {
  String goodbye(String arg);
  String hello(String arg);
}
产生错误信息:
NotFunctional is not a functional interface multiple
non-overriding abstract methods found in interface NotFunctional

NotFunctional不是一个功能接口，在接口NotFunctional中可以找到多个非覆盖的抽象方法
*/

public class FunctionalAnnotation {

    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;
        // Functional fac = fa; // Incompatible
        // 不允许将 FunctionalAnnotation 直接赋值给 Functional，因为 FunctionalAnnotation 没有明确说明实现 Functional 接口
        Functional fl = a -> "Goodbye, " + a;
        FunctionalNoAnn fnal = a -> "Goodbye, " + a;
    }
}
