package com.annotation.unit02annotationtracker;


import com.annotation.unit01basicgrammar.ele01defineannotation.PasswordUtils;
import com.annotation.unit01basicgrammar.ele01defineannotation.UseCase;
import com.sun.xml.internal.ws.api.client.WSPortInfo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 编写注解处理器
 * 如果没有读取注解的工具，那么注解也不会比注释更有用
 */
public class UseCaseTracker {
    public static void trackUserCases(List<Integer> useCases, Class<?> cl) {
        // getDeclaredMethods: 获取类中所有的方法
        for (Method m : cl.getDeclaredMethods()) {
            // getAnnotation： 返回指定类型的注解对象
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) { // 如果注解的方法上没有该类型的注解，返回null
                System.out.println("Found Use Case: " + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id())); // 通过id删除信息
            }
        }
        // 输出没有指定的userCases
        for (int i : useCases) {
            System.out.println("Warning: Missing use case - " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        // Collections.addAll： 将所有指定的元素添加到指定的集合中 addAll(Collection<? super T> c, T... elements)
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUserCases(useCases, PasswordUtils.class);
    }


}
