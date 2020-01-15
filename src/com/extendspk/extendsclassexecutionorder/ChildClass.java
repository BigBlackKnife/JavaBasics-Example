package com.extendspk.extendsclassexecutionorder;

/**
 * 子类
 * 在初始化子类的时候会执行父类初始化方法
 */
public class ChildClass extends FatcherClass {
    public ChildClass() {
        System.out.println("ChildrenClass");
    }

    public static void main(String[] args) {
        FatcherClass fc = new FatcherClass();
        ChildClass cc = new ChildClass();
        // 输出结果为:
        // FatcherClass
        // FatcherClass
        // ChildrenClass
    }
}
