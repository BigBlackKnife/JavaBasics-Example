package com.io.practice.transfer_and_rename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Blaife
 * @description I/O实践 转移并重命名文件
 * @date 2021/4/10 21:33
 *
 * 案例：重构项目站内信文件存储位置
 *
 * 问题：
 * 原先的文件上传是存储于一个文件价SMC中，
 * 且文件名称相比较数据库中存储的名称多出一些空格，
 * 可能存在多个消息共用一个文件的情况，（文件名相同，第二次上传的覆盖掉了）
 *
 * 现在要把文件全部转移到消息对应的文件夹下，以及将其名称修改为与数据库中的一致
 *
 */
public class Entrance {

    private static final String FILE_PATH = "D:\\GMS";

    public static void main(String[] args) {
        DataBaseData baseData = new DataBaseData();
        ArrayList<FileMessage> data = baseData.getData();

        for (FileMessage f : data) {
            // 创建对应文件夹
            File folder = new File(FILE_PATH + File.separator + f.getId());
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    // 判断文件
                    String fileNames = f.getFileName();
                    String[] fileNamesArr = fileNames.split(";");
                    for (String filename : fileNamesArr) {
                        File file = new File(FILE_PATH + File.separator + filename);
                        if (file.exists()) {
                            try {
                                FileUtil.copyFileUsingFileStreams(file, new File(FILE_PATH + File.separator + f.getId() + File.separator + filename));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            File realFile = FileUtil.getFileRealLocation(filename, new File(FILE_PATH));
                            try {
                                FileUtil.copyFileUsingFileStreams(realFile, new File(FILE_PATH + File.separator + f.getId() + File.separator + filename));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    System.out.println(f.getId() + " 创建失败");
                }
            }
        }
    }
}
