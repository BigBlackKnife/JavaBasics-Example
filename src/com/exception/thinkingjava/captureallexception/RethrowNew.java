package com.exception.thinkingjava.captureallexception;

/**
 * 自定义异常1
 */
class OneException extends Exception {
    public OneException(String s) {
        super(s);
    }
}

/**
 * 自定义异常2
 */
class TwoException extends Exception {
    public TwoException(String s) {
        super(s);
    }
}

/**
 * 在捕获异常之后抛出另一异常
 * 通过案例我们可以看到异常2只知道自己来自main。
 * 所以说我们永远不必清理之前的异常，它们都是用new在堆上创建对象，垃圾回收机制会自动把它清理掉
 *
 * =====================================================================================
 * 源于f()的异常
 * 第一次捕捉
 * com.exception.thinkingjava.captureallexception.OneException: thrown from f()
 * 	at com.exception.thinkingjava.captureallexception.RethrowNew.f(RethrowNew.java:28)
 * 	at com.exception.thinkingjava.captureallexception.RethrowNew.main(RethrowNew.java:35)
 * 第二次捕捉
 * com.exception.thinkingjava.captureallexception.TwoException: 在内部尝试
 * 	at com.exception.thinkingjava.captureallexception.RethrowNew.main(RethrowNew.java:39)
 * Disconnected from the target VM, address: '127.0.0.1:53899', transport: 'socket'
 * ======================================================================================
 */
public class RethrowNew {

    public static void f() throws OneException {
        System.out.println("源于f()的异常");
        throw new OneException("thrown from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("第一次捕捉");
                e.printStackTrace(System.out);
                throw new TwoException("在内部尝试");
            }
        } catch (TwoException e) {
            System.out.println("第二次捕捉");
            e.printStackTrace(System.out);
        }
    }

}
