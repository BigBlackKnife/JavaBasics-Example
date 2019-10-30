package com.io.characterstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流学习
 * @author Blaife
 */
public class CharacterReader {

    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("F:\\javaBasicsTest\\test.txt");
            // 1.返回此流使用的字符编码的名称  注意：并非读取的文件的字符编码
            String codedSet = fr.getEncoding();
            System.out.println(codedSet);

            // 2-1.read不使用参数
            int code = fr.read();
            System.out.println((char)code);

            // 2-2.read使用char[]参数
            char[] c = new char[1024];
            int count = fr.read(c);
            while (count != -1) {
                System.out.print(new String(c, 0, count));
                count = fr.read(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
