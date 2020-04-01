package com.packaging.customtoollibrary;

// static 静态导入
import static com.packaging.customtoollibrary.Print.*;

/**
 * @author Blaife
 * @description 打印工具测试
 * @data 2020/4/1 18:53
 */
public class PrintTest {

    public static void main(String[] args) {
        print("Available from now on!");
        print(100);
        print(100L);
        print(3.1415926);
    }

}
