package com.packaging.customtoollibrary;

import static com.packaging.customtoollibrary.Range.*;
/**
 * @author Blaife
 * @description 生成整数数据工具测试
 * @data 2020/4/1 19:24
 */
public class RangeTest {
    public static void main(String[] args) {
        for (int i : range(10)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : range(5, 10)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : range(5, 20, 2)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : range(20, 5, -2)) {
            System.out.print(i + " ");
        }
    }
}
