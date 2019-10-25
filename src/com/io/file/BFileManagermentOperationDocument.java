package com.io.file;

import java.io.File;
import java.io.IOException;

/**
 * File文件操作之文件操作
 * @author blaife
 */
public class BFileManagermentOperationDocument {
    public static void main(String[] args) throws IOException {

        // 1.创建文件 createNewFile 返回 boolean
        /*File file = new File("F:\\javaBasicsTest\\NewCreatFile.txt");
        System.out.println(file.createNewFile());*/

        // 2.创建文件夹 mkdir 返回boolean 只能创建一级，如果父级文件夹为创建则创建失败
        /*File file = new File("F:\\javaBasicsTest\\newDir");
        System.out.println(file.mkdir());*/

        // 3.创建多级文件夹 mkdir 返回boolean
        /*File file = new File("F:\\javaBasicsTest\\newDirs\\newDirs");
        System.out.println(file.mkdirs());*/

        // 4.获取父元素名称 返回string
        /*File file = new File("F:\\javaBasicsTest\\newDir");
        System.out.println(file.getParent());*/

        // 5.获取父文件 返回file 直接输出也会输出文件名，但是他本质上是一个文件
        /*File file = new File("F:\\javaBasicsTest\\newDir");
        File parentfile = file.getParentFile();
        System.out.println(file.getParentFile());*/

        // 6.获取子元素名称 返回string[] foreach循环输出
        /*File file = new File("F:\\javaBasicsTest");
        String[] fileList = file.list();
        for (String f : fileList) {
            System.out.println(f);
        }*/

        // 7.获取子元素对象 返回File[] 直接输出也会输出文件名，但是他本质上是一个文件
        /*File file = new File("F:\\javaBasicsTest");
        File[] fileList = file.listFiles();
        for (File f : fileList) {
            System.out.println(f);
        }*/

        // 8.删除文件（空文件夹或文件） 返回boolean 无法删除多级
        // 需要注意的是使用此方法删除的内容在回收站中是找不到的，属于完全删除
        /*File file = new File("F:\\javaBasicsTest\\newDirs\\newDirs");
        System.out.println(file.delete());*/
    }
}
