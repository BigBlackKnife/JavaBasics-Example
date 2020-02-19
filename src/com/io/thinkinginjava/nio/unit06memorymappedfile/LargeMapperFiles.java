package com.io.thinkinginjava.nio.unit06memorymappedfile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件 -- 假定整个文件都放在内存中
 */
public class LargeMapperFiles {

    static int length = 0x8FFFFFF;

    public static void main(String[] args) throws IOException {
        // 得到文件
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        // 循环将所有位置存放字符'x'
        for (int i = 0; i < length; i++) {
            out.put((byte)'x');
        }
        // 输出指定位置的内容
        System.out.println("Finished writing");
        for (int i  = length/2; i < length/2 + 6; i++) {
            System.out.print((char)out.get(i));
        }
    }

}
