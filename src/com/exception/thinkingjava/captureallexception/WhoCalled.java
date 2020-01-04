package com.exception.thinkingjava.captureallexception;

/**
 * 栈轨迹
 * 简单来说，栈轨迹就是这个错误所经过的方法
 * 比如我们常见的 controller中方法报错，发现是应用的service层中的mapper层中的方法出错了。
 * 那么这个错误的栈轨迹就是这个方法的集合，顺序为 mapper -- service -- controller
 */
public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() { f(); }
    static void h() { g(); }

    public static void main(String[] args) {
        f();
        System.out.println("-----------------------------------");
        g();
        System.out.println("-----------------------------------");
        h();
    }
}
