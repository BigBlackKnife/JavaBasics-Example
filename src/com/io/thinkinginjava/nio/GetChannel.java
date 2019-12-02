package com.io.thinkinginjava.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 新 io
 * 演示FileInputStream、FileOutputStream、RandomAccessFile三种类型的流产生可写的、可读可写的以及可读的通道
 */
public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        // 读一个文件
        FileChannel fc = new FileOutputStream("test.out").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        // 添加到文件的末尾
        fc = new RandomAccessFile("test.out", "rw").getChannel();
        fc.position(fc.size()); // 移动到末尾
        fc.write(ByteBuffer.wrap("Some more ".getBytes()));
        fc.close();

        // 读取文件
        fc = new FileInputStream("test.out").getChannel();
        // allocate 分配一个新的字节缓存空间
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char)buff.get());
        }
    }

}
