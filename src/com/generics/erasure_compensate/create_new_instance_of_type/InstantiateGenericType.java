package com.generics.erasure_compensate.create_new_instance_of_type;

import java.util.function.Supplier;

/**
 * @author Blaife
 * @description 创建类型实例
 * 传入一个工厂对象，并使用该对象创建新实例
 * @date 2020/11/29 10:40
 */

class ClassAsFactory<T> implements Supplier<T> {
    Class<T> kind;

    ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }

    @Override
    public T get() {
        try {
            return kind.newInstance();
        } catch (InstantiationException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
    @Override
    public String toString() {
        return "Employee";
    }
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println(fe.get());
        // Integer 没有无参构造函数, 此行会报错
        /*ClassAsFactory<Integer> in = new ClassAsFactory<>(Integer.class);
        System.out.println(in.get());*/
        ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        try {
            System.out.println(fi.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
