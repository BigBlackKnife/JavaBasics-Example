package com.io.thinkinginjava.standardio;

import java.io.PrintWriter;

/**
 * 将System.out转换成PrintWriter
 *
 * System.out是一个PrintWriter， 而PrintWriter是一个OutputStream，
 * PrintWriter有接收OutputStream类型的构造器，将其转换成PrintWriter
 * 第二个值设置为true，以便开启自动清空
 */
public class ChangeSystemOut {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello World");
    }

}
