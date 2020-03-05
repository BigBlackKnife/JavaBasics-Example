package com.enumerated.unit06randomchoice;

import com.utility.enumutils.Enums;

/**
 * 随机选取，工具类位于com.utility.enumutils.Enums
 */
enum Activity { SITTING, LYING, STANDING, HOPPING }

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(Activity.class) + " ");
        }
    }
}
