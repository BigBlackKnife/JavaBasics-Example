package com.io.thinkinginjava.typicaluse;

import java.io.*;

/**
 * IO流的典型使用方式--存储和恢复文件 重点在准确的读取数据
 * 使用Double作为简单的字节序列 readUTF使用的是UFF-8的变体，便于在安装有java环境的机器上多端运行，但不便于非java程序读取
 * @author Blaife
 */
public class StoringAndRecover {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
            new BufferedOutputStream(new FileOutputStream("Data.txt")));
        out.writeDouble(3.1415926);
        out.writeUTF("That is First");
        out.writeDouble(1.41413);
        out.writeUTF("这是根号2的值");
        out.close();

        DataInputStream in = new DataInputStream(
            new BufferedInputStream(new FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }

}
