package com.io.practice.transfer_and_rename;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Blaife
 * @description 模拟获取数据库数据
 * @date 2021/4/11 10:50
 */
public class DataBaseData {

    ArrayList<FileMessage> data = new ArrayList<>();

    public ArrayList<FileMessage> getData() {
        data.add(new FileMessage("f9404d7f-8494-4969-b08e-cb5cd6f2a874", "新建文本文档.txt;新建文本文档-副本.txt"));
        data.add(new FileMessage("b535dab6-0820-4532-b32b-c31c2699be3c", "新建文本文档.txt;"));
        return data;
    }
}

/**
 * file 实体类
 */
class FileMessage {
    private String id;
    private String fileName;  // A.jpg;B.jpg

    public FileMessage(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileMessage that = (FileMessage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fileName, that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName);
    }

    @Override
    public String toString() {
        return "FileMessage{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}