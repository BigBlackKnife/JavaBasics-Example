package com.io.thinkinginjava.typicaluse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * IO流的典型使用方式--缓冲输入文件
 */
public class BufferedInputFile {

    /**
     * 读取文件内容
     * @param filename 文件名
     * @return 文件内容
     */
    public static String read(String filename) throws IOException {
        // 创建缓冲流，参数为Reader,可以设置缓冲流最大值
        BufferedReader in = new BufferedReader(new FileReader(filename));
        // 此s用来接收缓冲流每次取出的值
        String s;
        // 此sb用来拼接读取的内容，使用此类型是因为在拼接过程中不会出现字符串片段，以及他是单线程的。
        StringBuilder sb = new StringBuilder();
        // readLine  读取一行
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        // 关闭流
        in.close();
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        System.out.println(read("src\\com\\io\\thinkinginjava\\typicaluse\\BufferedInputFile.java"));
    }
}
