package com.io.thinkinginjava.typicaluse;

import java.io.IOException;
import java.io.StringReader;

/**
 * IO流的典型使用方式--从内存输入
 */
public class MemoryInput {
    /**
     * 实际就是把String对象转换为StringReader,然后执行读取方法read。
     */
    public static void main(String[] args) throws IOException {
        StringReader sr = new StringReader(BufferedInputFile.read("src\\com\\io\\thinkinginjava\\typicaluse\\MemoryInput.java"));
        int c;
        while ((c = sr.read()) != -1) {
            System.out.print((char)c);
        }
    }

}
