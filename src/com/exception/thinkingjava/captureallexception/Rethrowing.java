package com.exception.thinkingjava.captureallexception;

/**
 * 重新抛出异常 -- fillInStackTrace（执行堆栈跟踪）
 */
public class Rethrowing {

    /**
     * 顶层方法，异常出现的位置
     * @throws Exception
     */
    public static void f() throws Exception {
        System.out.println("初始异常在方法f()");
        throw new Exception("抛出异常");
    }

    /**
     * 一般抛出异常
     * 输出了两次 一次是e.printStackTrace(System.out); 信息为f() g() main()
     * 另一次是main方法中的e.printStackTrace(); 信息为f() g() main()
     * @throws Exception
     */
    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("g()内部：e.printStackTrace");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    /**
     * 使用fillInStackTrace（执行堆栈跟踪）
     * 输出两次 1次是：h()中的e.printStackTrace(System.out); 信息为f() h() main()
     * 第二次是：main方法中的throwable.printStackTrace(); 信息为 h() main()
     * fillInStackTrace方法返回了一个Throwable对象，通过把调用栈信息填入原来异常中而建立的。
     * 我们也可以发现main方法中的h()方法的catch()块中，数据类型不是Exception而是Throwable
     * @throws Throwable
     */
    public static void h() throws Throwable {
        try {
            f();
        } catch (Exception e) {
            System.out.println("h()内部：e.printStackTrace");
            e.printStackTrace(System.out);
            // fillInStackTrace: 执行堆栈跟踪？
            throw (Exception)e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main：e.printStackTrace");
            e.printStackTrace();
        }

        try {
            h();
        } catch (Throwable throwable) {
            System.out.println("main：e.printStackTrace");
            throwable.printStackTrace();
        }
    }

}
