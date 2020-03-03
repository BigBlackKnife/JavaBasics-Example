package com.enumerated.unit01basiccharacteristics;

/**
 * 基本enum特性
 * ordinal、==、equals、getDeclaringClass、name、valueOf
 */
enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            // ordinal：表示声明顺序
            System.out.println(s + " ordinal: " + s.ordinal());
            // enum实现了Comparable接口，所以可以使用compareTo
            System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
            // equals：实例间的比较
            System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
            // ==：编译器自动提供equals()和hashcode()方法
            System.out.println(s == Shrubbery.CRAWLING);
            // getDeclaringClass：输出所属类
            System.out.println(s.getDeclaringClass());
            // name：输出实例声明时的名称
            System.out.println(s.name());
            System.out.println("------------------------------------");
        }
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            // valueOf：Enum类的静态方法，根据名称返回相应的enum实例
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}
