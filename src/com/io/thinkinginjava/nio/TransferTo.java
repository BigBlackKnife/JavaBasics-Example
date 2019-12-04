package com.io.thinkinginjava.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 一个通道与另一个通道直接相连 -- TransferTo  TransferForm
 */
public class TransferTo {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        // 输入通道
        FileChannel in = new FileInputStream(args[0]).getChannel();
        // 输出通道
        FileChannel out = new FileOutputStream(args[1]).getChannel();

        // transferTo 开始位置 要传输的最大字节数 目标通道
        in.transferTo(0, in.size(), out);
        // transferForm 源通道 开始位置 要传输的最大字节数
        // out.transferFrom(in, 0, in.size());

        in.close();
        out.close();
    }
}
