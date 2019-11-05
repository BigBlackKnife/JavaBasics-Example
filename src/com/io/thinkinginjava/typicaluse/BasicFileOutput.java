package com.io.thinkinginjava.typicaluse;

import java.io.*;

/**
 * IO流的典型使用方式--基本的文件输出
 * @author Blaife
 */
public class BasicFileOutput {

    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("src\\com\\io\\thinkinginjava\\typicaluse\\BasicFileOutput.java")));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        // 1.5之后PrintWriter添加了如下辅助构造方法
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ":" + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
