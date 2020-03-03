package com.enumerated;

/**
 * enum简单使用
 * 创建enum后，编译器会自动创建一些有用的特性：toString、ordinal、static values
 * toString() 输出
 * ordinal() 用来表示特定enum常量的声明顺序
 * static values() 按照enum常量的声明顺序，产生由这些常量值构成的数据
 */
public class SimpleEnumUse {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ", ordinal:" + s.ordinal());
        }
    }
}

/* 输出内容如下：
    NOT, ordinal:0
    MILD, ordinal:1
    MEDIUM, ordinal:2
    HOT, ordinal:3
    FLAMING, ordinal:4
*/
