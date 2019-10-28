package com.io.byteStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流学习之字节输出流学习类
 * @author Blaife
 */
public class ByteOutputStream {

    public static void main(String[] args) {

        FileOutputStream fos = null;
        try {
            // 1.创建字节输出流 -- 传递file对象或者路径
            // 第二个参数 append 表示是否追加，默认为false
            // 如果文件路径不存在则，创建自动文件
            fos = new FileOutputStream("F:\\javaBasicsTest\\test.txt", true);
            /*File file = new File("F:\\javaBasicsTest\\test.txt");
            FileOutputStream fos = new FileOutputStream("F:\\javaBasicsTest\\test.txt");*/

            // 2-1.写入文件方法write，参数：int
            fos.write(97);
            fos.flush(); // 将管道中的内容推入（刷新）到硬盘上,现在可以不写此方法

            // 2-2.写入文件方法write，参数：char
            fos.write('a');

            // 2-3.写入文件方法write，参数：byte[]
            // byte[] b = new byte[]{97,98,99,100,101};
            // 填写汉字还是有乱码的问题
            String str = "测试字节输入";
            byte[] b = str.getBytes();
            fos.write(b);

            System.out.println("输入结束");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if ( fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
