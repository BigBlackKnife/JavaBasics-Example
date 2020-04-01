package com.packaging.customtoollibrary;

import java.io.PrintStream;

/**
 * @author Blaife
 * @description 定制工具库 - 打印便捷工具
 * @data 2020/4/1 18:46
 */
public class Print {
    /**
     * 功能描述: 另起一行打印
     * @author: Blaife
     * @date: 2020/4/1 18:50
     * @param object 打印内容
     * @return: void
     */
    public static void print(Object object) {
        System.out.println(object);
    }

    /**
     * 功能描述: 换行
     * @author: Blaife
     * @date: 2020/4/1 18:50
     * @return: void
     */
    public static void print() {
        System.out.println();
    }

    /**
     * 功能描述: 不换行打印
     * @author: Blaife
     * @date: 2020/4/1 18:51
     * @param object 打印内容
     * @return: void
     */
    public static void printnb(Object object) {
        System.out.print(object);
    }

    /**
     * 功能描述: 向文件中打印
     * @author: Blaife
     * @date: 2020/4/1 18:51
     * @param format 指向文件
     * @param args 打印内容
     * @return: java.io.PrintStream
     */
    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }

}
