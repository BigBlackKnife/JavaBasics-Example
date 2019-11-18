package com.io.thinkinginjava.standardio;

import java.io.*;

/**
 * 标准I/O重定向
 * 使用setIn、setOut、setErr重定向标准IO,并在结尾处将系统输出恢复默认
 */
public class Redirecting {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("src\\com\\io\\thinkinginjava\\standardio\\Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(
                new FileOutputStream("test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
    }

}
