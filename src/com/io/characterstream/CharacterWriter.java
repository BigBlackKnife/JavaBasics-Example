package com.io.characterstream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流学习
 * @author Blaife
 */
public class CharacterWriter {

    public static void main(String[] args) {
        FileWriter fw = null;

        try {
            // 创建FileWriter对象
            fw = new FileWriter("F:\\javaBasicsTest\\test.txt", true);

            // 1.write的int参数方法，会将int参数转换为字符放入文件
            /*fw.write(123);*/

            // 2.write的String参数方法，需要注意的是会乱码, 可以添加参数进行截取
            /*fw.write("测试String数据",2,6);*/

            // 3.write的char[]参数方法，可以添加参数进行截取
            /*char[] cbuf = new char[]{'a','b','c','d','e','f'};
            fw.write(cbuf,2,4);*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
