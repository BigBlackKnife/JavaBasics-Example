package com.exception.thinkingjava.constructor;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 构造器：
 *
 * 当异常发生了，所有的资源都能够被正确的清理吗？
 *
 * 如果关闭资源的代码写在finally中，那么在创建资源时失败（资源没有成功创建），却需要关闭资源。
 *
 * 文件在InputFile对象的整个生命周期内都处于打开状态
 */
public class InputFile {

    private BufferedReader in;

    public InputFile(String fName) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fName));
        } catch (FileNotFoundException e) {
            System.out.println("打开资源失败：" + fName);
            throw e; // 在每次出现异常后向上层抛出简化编程。时关注点回到业务代码
        } catch (Exception e) {
            try {
                in.close();
                System.out.println("in.close() successful");
            } catch (IOException e2) {
                System.out.println("in.close() failed");
            }
            throw e;
        } finally {
            // 并不在这里关闭资源
        }
    }

    /**
     * 获取行
     * @return
     */
    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    /**
     * 关闭资源
     */
    public void dispose() {
        try {
            in.close();
            System.out.println("in.close() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close failed");
        }
    }
}
