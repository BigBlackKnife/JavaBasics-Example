package com.io.assignment;

import java.io.File;

/**
 * 迭代查询文件夹
 */
public class IterativeQueryFolder {
    // 创建文件及调用方法
    public static void main(String[] args) {
        outputChild("F:\\javaBasicsTest");
    }

    /**
     * 迭代查询一个文件夹
     * 先输出文件路径，如果有下级就继续调用自身方法
     * @param file
     */
    public static void outputChild(File file) {
        System.out.println(file.getPath());
        if (file.listFiles() != null && file.listFiles().length > 0) {
            for (File f: file.listFiles() ) {
                outputChild(f);
            }
        }
    }

    /**
     * 方法重载
     * @param filePath
     */
    public static void outputChild(String filePath) {
        File file = new File(filePath);
        outputChild(file);
    }

}
