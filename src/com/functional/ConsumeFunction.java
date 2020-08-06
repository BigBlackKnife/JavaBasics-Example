package com.functional;

import java.util.function.Function;

/**
 * @author Blaife
 * @description 消费函数需要在参数列表正确地描述函数类型
 * @data 2020/8/6 23:05
 */
class One {}

class Two {}

public class ConsumeFunction {
    static Two consume(Function<One,Two> onetwo) {
        return onetwo.apply(new One());
    }
    
    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
