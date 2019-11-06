package com.io.thinkinginjava.typicaluse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * IO流的典型使用方式--读写随机访问文件
 * 使用RandomAccessFile  getFilePointer获取光标未知 seek移动光标
 * @author Blaife
 */
public class UsingRandomAccessFile {
    static String file = "rtest.bat";
    static void display() {
        try {
            // RandomAccessFile构造方法 参数1为文件，参数2为访问模式 常用值为r:只读 rw:读写
            RandomAccessFile rf = new RandomAccessFile(file, "r");
            for (int i = 0; i < 7; i++) {
                System.out.println("Value" + i + ":" + rf.readDouble());
            }
            System.out.println(rf.readUTF());
            rf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            RandomAccessFile rf = new RandomAccessFile(file, "rw");
            for (int i = 0; i < 7; i++) {
                rf.writeDouble(i * 1.414);
            }
            rf.writeUTF("The end of the file");
            rf.close();
            display();
            rf = new RandomAccessFile(file, "rw");
            rf.seek(5*8);
            rf.writeDouble(47.0001);
            rf.close();
            display();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
