package com.exception.thinkingjava.customexception;


/**
 * 自定义异常
 */
class MyException2 extends  Exception {
    private int x; // 设置变量

    /**
     * 无参构造函数
     */
    public MyException2() {
    }

    ;

    /**
     * 单参构造函数
     *
     * @param msg
     */
    public MyException2(String msg) {
        super(msg);
    }

    /**
     * 双参构造函数
     *
     * @param msg
     * @param x
     */
    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    /**
     * 输出变量值
     *
     * @return
     */
    public int val() {
        return x;
    }

    /**
     * 重写getMessage方法
     * @return
     */
    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}

/**
 * 自定义异常 -- 加入额外构造器及成员
 */
public class ExtraFeatures {

    public static void f() throws MyException2 {
        System.out.println("Throwing MyException2 from f()");
        throw new MyException2();
    }

    public static void g() throws MyException2 {
        System.out.println("Throwing MyException2 from g()");
        throw new MyException2("Originated in g()");
    }

    public static void h() throws MyException2 {
        System.out.println("Throwing MyException2 from h()");
        throw new MyException2("Originated in h()", 47);
    }


    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
            System.out.println("e.val() = " + e.val() );
        }
    }

}
