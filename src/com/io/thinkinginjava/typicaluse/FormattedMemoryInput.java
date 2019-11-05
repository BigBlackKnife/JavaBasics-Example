package com.io.thinkinginjava.typicaluse;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * IO流的典型使用方式--格式化内存输入
 *
 * 此案例使用异常来控制执行流程，这个方法是不可取的,因为使用的是readByte所以当读取不到时直接异常，
 * 如果使用read返回int字符的话，读取不到返回-1，就可以通过返回值判断是否转义了，详见案例 -- ByteInputStream
 * 使用avaliable判断还有多少可供存取的数据 详见案例 -- TestEOF
 * 问题 : 一个字节一个字节的读取会产生的问题是一个中文为两个字节导致中文乱码。
 */
public class FormattedMemoryInput {
    public static void main(String[] args){
        try {
            DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(
                    BufferedInputFile.read("src\\com\\io\\thinkinginjava\\typicaluse\\BufferedInputFile.java").getBytes()));
            while (true) {
                System.out.print((char)in.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
