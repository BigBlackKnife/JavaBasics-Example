package com.exception.thinkingjava.captureallexception;

/**
 * 捕获所有异常
 */
public class ExceptionMethodss {

    public static void main(String[] args) {
        try {
            /*int[] i = new int[]{1};
            System.out.println(i[100]);*/
            // 输出内容如下： Message为100
            // 一些Exception默认封装了一些取值Message位置
            /*Caught Exception
            getMessage():100
            getLocalizedMessage:100
            toString:java.lang.ArrayIndexOutOfBoundsException: 100
            printStackTrace():java.lang.ArrayIndexOutOfBoundsException: 100
            at com.exception.thinkingjava.captureallexception.ExceptionMethodss.main(ExceptionMethodss.java:11)*/

            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage:" + e.getLocalizedMessage());
            System.out.println("toString:" + e);
            System.out.print("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }

}
