package com.io.thinkinginjava.practicaltool;

import java.io.*;

/**
 * 读取二进制文件
 *
 * 本质就是使用字节流读取文件，获取文件内字节长度，通过此长度设置byte数组长度，然后进行一次读取
 */
public class BinaryFile {
    public static byte[] read(File bFile) {
        BufferedInputStream bf = null;
        try {
            bf = new BufferedInputStream(new FileInputStream(bFile));
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }

    public static byte[] read(String bFile) {
        return read(new File(bFile));
    }
}
