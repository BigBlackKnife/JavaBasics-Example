package com.enumerated.unit04mysticalvalues;

import javax.swing.*;

/**
 * getEnumContants()是class上的方法
 * 对不是枚举的类调用getEnumContants()方法
 * 但是该方法返回null
 */
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Object en : intClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
