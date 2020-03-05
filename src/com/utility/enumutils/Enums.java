package com.utility.enumutils;

import java.util.Random;

/**
 * 从enum实例中随机选取
 * 使用泛型使工作一般化
 *
 * 即调用random方法传递Enum的子类class，
 * getEnumConstants方法取到所有的实例对象，然后随机输出
 */
public class Enums {
    private static Random random = new Random(47);

    /**
     * 传递class对象
     * @param ec class对象
     * @param <T> 一个Enum的子类
     * @return
     */
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    /**
     * 输入一个数组 然后随机输出数组中的一个值
     * @param values 数组
     * @param <T> 泛型
     * @return
     */
    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}
