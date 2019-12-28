package com.exception.thinkingjava.customexception;

/**
 * 自定义异常
 */
// 异常类  内部类
class SimpleException extends Exception{}

public class InheritingExceptions {

    // 方法 f 抛出异常
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    // main方法 在调用 f() 时会执行到 throw new SimpleException异常
    // 这样调用是为了 更好的模拟
    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            e.printStackTrace();
            System.out.println("Caught it!");
        }
    }

}
