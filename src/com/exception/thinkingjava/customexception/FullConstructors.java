package com.exception.thinkingjava.customexception;

/**
 * 自定义错误MyException
 */
class MyException extends Exception {
    public MyException() {};
    public MyException(String msg) {
        super(msg);
    }
}


/**
 * 当前类
 */
public class FullConstructors {
    /**
     * 抛出MyException异常 无提示信息
     * @throws MyException
     */
    public static void f() throws MyException {
        System.out.println("Throws MyExcepion from f()");
        throw new MyException();
    }

    /**
     * 抛出MyException异常 有提示信息Originated in g()
     * @throws MyException
     */
    public static void g() throws MyException {
        System.out.println("Throws MyExcepion from g()");
        throw new MyException("Originated in g()");
    }

    /**
     * 主方法执行
     * @param args
     */
    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }

}
