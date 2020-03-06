package com.enumerated.unit08enumset;

import java.util.EnumSet;
import static com.enumerated.unit08enumset.AlarmPoints.*;

/**
 * EnumSet替代标志 JavaSE5时引进
 * EnumSet将long值作为比特向量，非常的快速高效
 * EnumSet中的元素必须来自一个enum
 * EnumSet在说明一个二进制是否有效时具有更好的表达能力
 * EnumSet的基础时一个long（64位）,一个Enum实例需要1bit,如果enum超过了64个元素，也是可用的（可能是在必要的时候扩展了一个long）
 */
public class EnumSets {
    // noneOf:创建具有指定元素类型的空枚举集。
    // allOf:创建一个enum集合，该集合包含指定元素类型中的所有元素。
    // add:添加一个元素
    // addAll:这个实现遍历指定的集合，并依次将迭代器返回的每个对象添加到这个集合中。
    // remove:删除一个元素
    // removeAl:从该集合中移除指定集合中包含的所有元素(可选操作)。如果指定的集合也是一个集合，使其值为两个集合的差值
    // of:调用add方法，将传入的实例合并为一个EnumSet.(需要这些元素必须来自一个enum)(被重载了很多次，参数个数支持1-5)；
    // range:创建一个enum集合，该集合最初包含由两个指定端点定义的范围内的所有元素。返回的集合将包含端点本身，它们可以是相同的，但一定不能顺序混乱。
    // complementOf:使用与指定的enum集合相同的元素类型创建一个enum集合，包含的元素时指定enum中没有的元素
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        System.out.println(points);
        points.add(BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.allOf(AlarmPoints.class));
        System.out.println(points);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }

}
