package com.packaging.customtoollibrary;

/**
 * @author Blaife
 * @description 定制工具库 - 生成整数数列工具
 * @data 2020/4/1 19:01
 */
public class Range {

    /**
     * 功能描述: 生成[0,n)的整数数组
     * @author: Blaife
     * @date: 2020/4/1 19:03
     * @param n 数组长度
     * @return: int[]
     */
    public static int[] range(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i ++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * 功能描述: 生成【start,end)范围的整数数组
     * @author: Blaife
     * @date: 2020/4/1 19:05
     * @param start 开始数字
     * @param end 结束数子
     * @return: int[]
     */
    public static int[] range(int start, int end) {
        int size = end - start;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i + start;
        }
        return result;
    }

    /**
     * 功能描述: 生成【start,end)范围指定步进值的整数数组
     * @author: Blaife
     * @date: 2020/4/1 19:22
     * @param start 开始数字
     * @param end 结束数字
     * @param step 步进值
     * @return: int[]
     */
    public static int[] range(int start, int end, int step) {
        int size = (end - start) / step;
        if (Math.abs(end - start) % Math.abs(step) != 0 ) {
            size++;
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i ++) {
            result[i] = i * step + start;
        }
        return result;
    }

}
