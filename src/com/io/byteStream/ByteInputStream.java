package com.io.byteStream;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节输入流学习类
 * @author Blaife
 */
public class ByteInputStream {
    public static void main(String[] args) {
        try {
            // 1.FileInputStream的创建方式：根据路径和File对象。
            FileInputStream fis = new FileInputStream("F:\\javaBasicsTest\\test.txt");
            /*File file = new File("F:\\javaBasicsTest\\test.txt");
            FileInputStream fis = new FileInputStream(file);*/

            // 2-1.read方法读取内容:无参数，仅读取一个字节
            int code = fis.read();
            while (code != -1) {
                System.out.print((char)code);
                code = fis.read(); // Unicode码 0-65535  中文会存在乱码情况
            }

            // 2-2.read方法读取内容:byte[] 参数，读取多个字节存入数据内
            byte[] b = new byte[20];
            // 在文件中读取内容后装入数组内，返回值为读取到的有效字节
            int count = fis.read(b);
            while (count != -1) {
                // 选择输出内容 从0到读取内容。
                String value = new String(b, 0, count);
                System.out.print(value);
                count = fis.read(b);
            }

            // 3.available 获取管道中还有多少内容，常用于基本流，不用于高级流
            // 在开头使用和结尾使用结果是不一样的，因为中间有操作字节流
            int len = fis.available();
            System.out.println();
            System.out.println(len);

            // 4.skip方法，跳过几个字节。常用与多线程,// 返回值为long
            // 可以使用负值，使其反向跳跃。
            long v = fis.skip(-9);
            System.out.println(v);
            code = fis.read();
            System.out.println((char)code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
