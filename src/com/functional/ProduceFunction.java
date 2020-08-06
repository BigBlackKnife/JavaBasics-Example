package com.functional;

import java.util.function.*;

/**
 * @author Blaife
 * @description TODO
 * @data 2020/8/6 22:56
 */
interface
FuncSS extends Function<String, String> {} // [1] 使用继承，可以轻松地为专用接口创建别名。

public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase(); // [2] 使用 Lambda 表达式，可以轻松地在方法中创建和返回一个函数。
    }
    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
