package com.interview.parsestring;


import java.util.HashMap;

/**
 * @author Blaife
 * @description 分析字符串
 * @date 2021/5/11 23:21
 */
public class ParseString {

    public static void main(String[] args) {
        String str = "aBc122D9B";
        statisticsCharAndNum(str);
        statisticsCharAndNumForBeJoined(str);
        countTheNumberOfTimes(str);
        theCharacterWithTheMostCounts(str);
    }

    /**
     * 统计字符串中字符和数字的个数
     * @param str
     */
    public static void statisticsCharAndNum(String str) {
        int charAmount = 0;
        int numAmount = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((int)str.charAt(i) >= 48 && (int)str.charAt(i) <= 57) {
                numAmount ++;
            } else {
                charAmount ++;
            }
        }
        System.out.println("1: 字符总数：" + charAmount);
        System.out.println("1: 数字总数：" + numAmount);
    }

    /**
     * 统计字符串中字符和数字的个数
     * 数字相连算一个
     * @param str
     */
    public static void statisticsCharAndNumForBeJoined(String str) {
        int charAmount = 0;
        int numAmount = 0;
        boolean perNumFlag = false;
        for (int i = 0; i < str.length(); i++) {
            if ((int)str.charAt(i) >= 48 && (int)str.charAt(i) <= 57) {
                if (!perNumFlag) {
                    numAmount ++;
                    perNumFlag = true;
                }
            } else {
                charAmount ++;
                perNumFlag = false;
            }
        }
        System.out.println("2: 字符总数：" + charAmount);
        System.out.println("2: 数字总数：" + numAmount);
    }

    /**
     * 字符大小写不区分，统计字符的个数及出现次数
     * @param str
     */
    public static void countTheNumberOfTimes(String str) {
        str = str.toLowerCase();
        HashMap<Character, Integer> charMap = new HashMap<>();
        char currentChar;
        for (int i = 0; i < str.length(); i ++) {
            currentChar = str.charAt(i);
            if (charMap.containsKey(currentChar)) {
                charMap.put(currentChar, charMap.get(currentChar)+1);
            } else {
                charMap.put(currentChar, 1);
            }
        }

        System.out.println("3" + charMap);
    }

    /**
     * 统计出现次数最多的字符和数字
     * @param str
     */
    public static void theCharacterWithTheMostCounts(String str) {
        char maxNum = 0;
        char maxChar = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        char currentChar;
        for (int i = 0; i < str.length(); i ++) {
            currentChar = str.charAt(i);
            if (charMap.containsKey(currentChar)) {
                int currentNum = charMap.get(currentChar) + 1;
                charMap.put(currentChar, currentNum);
                if ((int)str.charAt(i) >= 48 && (int)str.charAt(i) <= 57) {
                    if (maxNum != currentChar && charMap.get(maxNum) < charMap.get(currentChar)) {
                        maxNum = currentChar;
                    }
                } else {
                    if (maxChar != currentChar && charMap.get(maxChar) < charMap.get(currentChar)) {
                        maxChar = currentChar;
                    }
                }
            } else {
                charMap.put(currentChar, 1);
                if ((int)str.charAt(i) >= 48 && (int)str.charAt(i) <= 57) {
                    if (maxNum == 0) {
                        maxNum = currentChar;
                    }
                } else {
                    if (maxChar == 0) {
                        maxChar = currentChar;
                    }
                }
            }
        }

        System.out.println("4: 出现次数最多的数字是" + maxNum);
        System.out.println("4: 出现次数最多的字符是" + maxChar);
    }
}
