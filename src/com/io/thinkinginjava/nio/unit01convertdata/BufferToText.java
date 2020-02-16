package com.io.thinkinginjava.nio.unit01convertdata;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 转换数据 一共是三个例子，
 */
public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {

        /*"""""""""""""""例1：直接书输出Charbuffer（乱码），使用Charset解决"""""""""""""""*/

        // FileChannel：用于读取，写入，映射和操作文件的通道
        // 向文件中输入信息
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text ".getBytes()));
        fc.close();

        // 从文件中输出信息
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip(); // 通过一系列的通道读取和输出操作后调用此方法来准备写入和输出信息
        // asCharBuffer:Charbuffer类存在toString方法，ByteBuffer.asCharBuffer == Charbuffer
        System.out.println(buff.asCharBuffer());
        buff.rewind(); // 倒带缓冲区，位置回到起点，标记将清除
        // 得到默认字符集
        String encoding = System.getProperty("file.encoding");
        // Charset:该类提供了把数据编码成多种不同类型的字符集的工具
        System.out.println("Decoded using " + encoding + ";" + Charset.forName(encoding).decode(buff));

        /*"""""""""""""""例2：存储时设置编码格式为UTF-16BE"""""""""""""""*/

        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        /*"""""""""""""""例3：使用CharBuffer向CharBuffer写入"""""""""""""""*/
        fc = new FileOutputStream("data2.txt").getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

    }

}
