package com.io.thinkinginjava.objectserialization.unit01findclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 取出Alien对象
 * 需要Alien正好在类路径classpath中，必须保证java虚拟机中能找到相关的.class文件
 *
 * 先执行FreezeAlien，然后执行ThawAlien,可以找到类，将.class文件删除之后再次尝试将出现ClassNotFoundException异常
 */
public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
