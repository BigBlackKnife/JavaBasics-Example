package com.enumerated.unit04mysticalvalues;

import com.io.thinkinginjava.processcontrol.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * values()的神秘之处
 *
 * Enum类中并没有values()方法，它是由编译器提供的static方法
 */
enum Explore { HERE, THERE }

public class Reflection {

    /**
     * 反射机制 -- 输入类 输出类中的方法集合
     * @param enumClass 类.class
     * @return
     */
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("--------- Analyzing " + enumClass + "---------");
        System.out.println("Interfaces: ");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> explorMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " + explorMethods.containsAll(enumMethods));
        System.out.print("Explore.removeAll(Enum): ");
        explorMethods.removeAll(enumMethods);
        System.out.println(explorMethods);
        OSExecute.command("java Explore");

    }


}
