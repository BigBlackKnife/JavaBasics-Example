package com.enumerated.unit07useinterfacestoorganize;

import com.utility.enumutils.Enums;

/**
 * 枚举的枚举
 *
 * 使用新的enum中的实例包装Food中的每一个enum类
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    /**
     * 一个数组变量 保存当前枚举中的所有实例
     */
    private Food[] values;

    /**
     * 构造方法 在取到实例中将此枚举中的所有内容存储到values[]中
     * @param kind 当前枚举类
     */
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    /**
     * 随机选取，调用了 enumutils.Enum中的随机选取方法
     * @return
     */
    public Food randomSelection() {
        return Enums.random(values);
    }

    /**
     * 通过下标获取Food实例对象
     * 但容易出现下表越界的情况 毕竟每一个枚举对象的长度使不一致的。
     * 可以在这个方法中进行下标的判断，但是操作起来并不方便
     * @param index
     * @return
     */
    public Food getEnumByIndex(int index) {
        return values[index];
    }
}
