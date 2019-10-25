package com.io.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File文件操作之获取文件自身属性
 * @author blaife
 */
public class AFileManagementGetOwnProperty {
    public static void main(String[] args) {
        // 创建file对象，请先在F盘创建javaBasicsTest文件夹及test.txt文件
        File file = new File("F:\\javaBasicsTest\\test.txt");
        // 1.canExaecute 是否可执行 返回 boolean
        System.out.println("是否可执行"+file.canExecute());
        // 2.canRead 是否可读 返回 boolean
        System.out.println("是否可读"+file.canRead());
        // 3.canWrite 是否可写 返回 boolean
        System.out.println("是否可写"+file.canWrite());
        // 4.isHidden 是否隐藏 返回 boolean
        System.out.println("是否隐藏"+file.isHidden());
        // 5.length 获取长度即大小 返回 long‘
        System.out.println("文件大小"+file.length()+"字节");
        // 5.lastModified 获取最后修改时间 返回 long 可以使用data转换
        long lastModified = file.lastModified();
        System.out.println("最后修改时间（毫秒数）"+lastModified);
        Date date = new Date(lastModified);
        System.out.println("最后修改时间（时间）"+date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("最后修改时间（符合阅读格式的）"+sdf.format(date));
        // 6.getAbsolutePath 获取绝对路径 返回 string
        System.out.println("文件绝对路径"+file.getAbsoluteFile());
        // 7.getPath 获取路径 不规范格式 返回 string
        System.out.println("文件路径"+file.getPath());
        // 9.getName 获取文件名 返回 string
        System.out.println("文件名"+file.getName());
    }
}
