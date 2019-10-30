package com.io.assignment;

import java.io.*;

/**
 * 通过字节流复制文件
 * @author Blaife
 */
public class copyFileByByte {

    public static void main(String[] args) {
        String result = copyFileByByte("F:\\javaBasicsTest\\test.txt", "F:\\javaBasicsTest\\newDir");
        System.out.println(result);
    }

    /**
     * 通过字节流拷贝文件
     * @param sFile 源文件
     * @param dFolder 目标文件夹
     * @return
     */
    public static String copyFileByByte(File sFile, String dFolder){
        // 1.获取sfile文件名
        // 2.将文件名添加到dFolder中
        // 3.读取所有的sFile中的字节数据
        // 4.获取目前文件file
        // 5.字节写入
        // 6.关闭流
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 字节输入流输出流创建
            fis = new FileInputStream(sFile);
            String fileName = sFile.getName();
            dFolder += File.separator + fileName;
            fos = new FileOutputStream(dFolder, true);

            // 读取字节内容
            byte[] b = new byte[1024];
            int count = fis.read(b);
            while (count != -1) {
                fos.write(b, 0, count);
                count = fis.read(b);
            }
            return "拷贝完成";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "系统找不到指定的文件";
        } catch (IOException e) {
            e.printStackTrace();
            return "拷贝失败";
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
    }

    /**
     * 方法重载
     * @param sFile
     * @param dFolder
     * @return
     */
    public static String copyFileByByte(String sFile, String dFolder){
        File file = new File(sFile);
        return copyFileByByte(file, dFolder);
    }
}
