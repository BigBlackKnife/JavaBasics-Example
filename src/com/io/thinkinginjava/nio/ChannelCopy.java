package com.io.thinkinginjava.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 创建两个通道进行读写操作
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        System.out.println(args.length);
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}
