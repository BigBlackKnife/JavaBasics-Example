package com.io.thinkinginjava.compress.unit01gzipexample;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * GZIP接口非常的简单，适用于单个数据类进行压缩
 * 压缩完毕后 打开文件发现没有的了后缀名 且解压之后出现乱码
 */
public class GZIPcompress {

    public static void main(String[] args) throws IOException {
        // 读取文件内容
        BufferedReader in = new BufferedReader(new FileReader("file.txt"));

        // 输入文件内容 使用GZIPOutputStream
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file");
        // 压缩完毕

        // 开始解压缩并输出
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }

    }

}
