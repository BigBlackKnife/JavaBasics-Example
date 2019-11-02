package com.io.thinkinginjava.directoryutility;

import java.io.File;

/**
 * 获取文件demo
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        System.out.println(Directory.walk("."));

        for (File file : Directory.local(".", "D.*")){
            System.out.println(file);
        }

        System.out.println("------------------------------------");

        for (File file : Directory.walk(".", "D.*\\.java")){
            System.out.println(file);
        }

        System.out.println("====================================");

        for (File file : Directory.walk(".", ".*\\.class")){
            System.out.println(file);
        }
    }

}
