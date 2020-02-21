package com.io.thinkinginjava.compress.unit02zipexample;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * 用ZIP进行多文件的保存
 * Zip格式的java库更加全面，可以方便的保存多个文件
 * 压缩之后外部打开一切正常（文件名及后缀名）， 但中文依旧乱码
 * 且idea出现如下错误：Cannot locate latest build tools
 * 可能是由于window系统使用的并非是utf-8的编码格式 而是ANSI格式
 *
 * 注意：
 * ZIP类库不提供设置密码功能
 * GZIP和ZIP的使用不仅仅局限于文件，它可以压缩任何东西，包括需要网络发送的数据
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {
        // TODO 压缩文件
        // 设置文件集
        String[] params = new String[]{"data2.txt", "file.txt", "test.out"};
        // 设置文件输出流
        FileOutputStream f = new FileOutputStream("test.zip");
        // 设置Checksum类型为Adler32
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        // 设置zip格式输出流
        ZipOutputStream zos = new ZipOutputStream(csum);
        // 输出缓冲流
        BufferedOutputStream out = new BufferedOutputStream(zos);
        // 设置文件注释
        zos.setComment("A test of java zipping");
        // 循环文件集，放入zip流中
        for (String arg : params) {
            System.out.println("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            // 对于每一个要加入压缩档案的文件都必须调用putNextEntry,并将其传递给一个ZipEntry
            // ZipEntry包含了一个功能广泛的接口
            zos.putNextEntry(new ZipEntry(arg));
            // 将内容推入输出流
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();
        // 返回此输出流的检验和
        System.out.println("CheckSum: " + csum.getChecksum().getValue());

        // TODO 读取文件
        System.out.println("Reading file");
        FileInputStream fi = new FileInputStream("test.zip");
        // 同样需要设置Checksum类型
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        // zip输入流
        ZipInputStream in2 = new ZipInputStream(csumi);
        // 交给缓冲流
        BufferedInputStream bis = new BufferedInputStream(in2);
        // 遍历每一个文件
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            System.out.println("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1) {
                System.out.print((char) x);
            }
            System.out.println();
        }
        // 再次输出校验值
        System.out.println("Checksm: " + csumi.getChecksum().getValue());
        bis.close();

        // TODO 输出zip文件中所有的文件名
        ZipFile zf = new ZipFile("test.zip");
        // 返回zip文件项的枚举
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry)e.nextElement();
            System.out.println("File: " + ze2);
        }
    }
}
