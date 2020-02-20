package com.io.thinkinginjava.nio.unit07filelock;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 文件加锁
 * 文件加锁机制，允许我们同步访问某个作为共享资源的文件
 */
public class FileLocking {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        // tryLock 获取文件锁，当不能获得时会直接从方法调用返回
        // lock 则为阻塞式，它会阻塞进程直至锁可以获得
        // tryLock(long position, long size, boolean shared) 或者
        // lock(long position, long size, boolean shared)
        // 对文件一部分上锁
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null) {
            System.out.println("Lock File");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release(); // 释放锁
            System.out.println("Released Lock");
        }
        fos.close();
    }

}
