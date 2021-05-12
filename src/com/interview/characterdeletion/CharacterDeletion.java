package com.interview.characterdeletion;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Blaife
 * @description 删除字符
 * @date 2021/5/12 8:46
 *
 * 要求：删除一个字符串中出现次数最多的字符，如果多个字符出现次数一样，则都删除。要求字符顺序不变。
 */
public class CharacterDeletion {

    public static void main(String[] args) {
        System.out.println(getRightString("ABCCDGSBBEER"));
    }

    public static String getRightString(String source) {
        int maxNum = 0;
        HashSet<Character> charSet = new HashSet<>();
        HashMap<Character, Integer> charMap = new HashMap<>();
        char currentChar;
        for (int i = 0; i < source.length(); i ++) {
            currentChar = source.charAt(i);
            if (charMap.containsKey(currentChar)) {
                int currentNum = charMap.get(currentChar) + 1;
                charMap.put(currentChar, currentNum);
                if (maxNum < currentNum) {
                    maxNum = currentNum;
                    charSet = new HashSet<>();
                    charSet.add(currentChar);
                } else if (maxNum == currentNum) {
                    charSet.add(currentChar);
                }
            } else {
                charMap.put(currentChar, 1);
                if (maxNum <= 1) {
                    maxNum = 1;
                    charSet.add(currentChar);
                }
            }
        }

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < source.length(); i ++) {
            currentChar = source.charAt(i);
            if (!charSet.contains(currentChar)) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
