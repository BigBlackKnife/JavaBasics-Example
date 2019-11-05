package com.io.thinkinginjava.typicaluse;

import java.io.*;

/**
 * IO流的典型使用方式--格式化内存输入-使用available控制输出
 */
public class TestEOF {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                    new FileInputStream("src\\com\\io\\thinkinginjava\\typicaluse\\TestEOF.java")));
            while (in.available() > 0) {
                System.out.print((char)in.readByte());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
