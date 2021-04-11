package com.io.practice.transfer_and_rename;

import java.io.*;
import java.util.Objects;

/**
 * @author Blaife
 * @description file工具类
 * @date 2021/4/11 11:07
 */
public class FileUtil {

    /**
     * 根据文件名及文件夹获取对应文件 (去空格)
     *
     * @param fileName 文件名（数据库中的文件名）
     * @param folder   文件夹
     * @return 真实对应文件
     */
    public static File getFileRealLocation(String fileName, File folder) {
        for (String f : Objects.requireNonNull(folder.list())) {
            if (f.replaceAll(" ", "").equals(fileName)) {
                return new File(folder.getPath() + File.separator + f);
            }
        }
        return null;
    }

    /**
     * 使用 FileStreams 复制文件
     * @param source 原文件
     * @param dest 新文件
     * @throws IOException IO
     */
    public static void copyFileUsingFileStreams(File source, File dest) throws IOException {
        try (InputStream input = new FileInputStream(source); OutputStream output = new FileOutputStream(dest)) {
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, bytesRead);
            }
        }
    }
}
