package com.io.Assignment;

import java.io.*;

/**
 * 通过字节流复制文件夹
 * @author Blaife
 */
public class CopyFolderByByte {
    /**
     * 通过字节流复制文件夹用到了迭代操作
     * 简单demo请查看类：IterativeQueryFolder
     */
    public static void main(String[] args) {
        copyFlderByByte("F:\\javaBasicsTest\\newDir", "F:\\javaBasicsTest\\newDirs");
    }

    /**
     * 通过字节流拷贝文件或文件夹
     * @param sFile 源文件
     * @param dFolder 目标文件夹
     * @return String
     */
    public static void copyFlderByByte(File sFile, String dFolder){
        /**
         * 1.文件 直接拷贝文件即可
         * 2.空文件夹 创建文件夹即可
         * 3.文件夹 创建文件夹并迭代调用
         */
        if (sFile.listFiles() == null) {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                // 字节输入流输出流创建
                fis = new FileInputStream(sFile);
                String fileName = sFile.getName();
                dFolder += File.separator + fileName;
                fos = new FileOutputStream(dFolder);
                // 读取字节内容
                byte[] b = new byte[10];
                int count = fis.read(b);
                while (count != -1) {
                    fos.write(b, 0, count);
                    count = fis.read(b);
                }
                System.out.println("文件"+sFile.getAbsolutePath()+"拷贝完成");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // 先创建文件夹，如果有下级文件则迭代调用，如果没有，则不再继续处理
            String fileName = sFile.getName();
            dFolder += File.separator + fileName;
            File newFile = new File(dFolder);
            newFile.mkdir();
            System.out.println("文件夹"+dFolder+"创建完成");
            if (sFile.listFiles().length > 0) {
                for (File f: sFile.listFiles() ) {
                    copyFlderByByte(f, dFolder);
                }
            }
        }
    }

    /**
     * 方法重载
     * @param sFile 源文件路径
     * @param dFolder 目标路径
     * @return static
     */
    public static void copyFlderByByte(String sFile, String dFolder){
        File file = new File(sFile);
        copyFlderByByte(file, dFolder);
    }
}
