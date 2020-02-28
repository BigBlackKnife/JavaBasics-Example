package com.io.thinkinginjava.objectserialization.unit03usingpersistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用“持久化” -- 两个对象都具有第三个对象的引用，序列化之后的结果是怎样的
 * Animal中引用了House，对Animal序列化两次，
 * 序列化到单一流，不会有重复复制的现象（animal1和animal2中地址相同，包括引用）
 * 序列化的两个流中，得到的是两个不同的关系网（animal2和animal3中地址不同，包括引用）
 */
class House implements Serializable {}

class Animal implements Serializable {
    private String name;
    private House preferredHouse;

    Animal(String name, House preferredHouse) {
        this.name = name;
        this.preferredHouse = preferredHouse;
    }

    @Override
    public String toString() {
        return name + "[" + super.toString() + "], " + preferredHouse + "\n";
    }
}

public class MyWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bosco the Dog", house));
        animals.add(new Animal("Ralph the hamster", house));
        animals.add(new Animal("Molly the cat", house));
        System.out.println("animals: \n" + animals);
        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream out1 = new ObjectOutputStream(buf1);
        out1.writeObject(animals);
        out1.writeObject(animals);
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(buf2);
        out2.writeObject(animals);
        ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
        @SuppressWarnings("all")List<Animal> animals1 = (List<Animal>) in1.readObject();
        @SuppressWarnings("all")List<Animal> animals2 = (List<Animal>) in1.readObject();
        @SuppressWarnings("all")List<Animal> animals3 = (List<Animal>) in2.readObject();
        System.out.println("animals1: \n" + animals1);
        System.out.println("animals2: \n" + animals2);
        System.out.println("animals3: \n" + animals3);
    }
}
