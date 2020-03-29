package com.extendspk.extendsclassexecutionorder;

/**
 * 子类
 * 在初始化子类的时候会执行父类初始化方法
 * @author Blaife
 */
public class ChildClass extends FatherClass {
    public ChildClass() {
        System.out.println("ChildrenClass");
    }

    public static void main(String[] args) {
        FatherClass fc = new FatherClass();
        ChildClass cc = new ChildClass();
        // 输出结果为:
        // FatherClass
        // FatherClass
        // ChildrenClass
    }
}
