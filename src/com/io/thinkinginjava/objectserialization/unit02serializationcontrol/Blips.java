package com.io.thinkinginjava.objectserialization.unit02serializationcontrol;

import java.io.*;

/**
 * 序列化的控制
 * Externalizable对象构造器的修饰符需要是public，否则出现InvalidClassException异常
 * 对于Serializable而言：对象完全以它存储的二进制位为基础来进行构造，而不调用构造器。
 * 对于Externalizable而言：所有普通的默认构造器都会被调用，然后调用readExternal().
 */

class Blip1 implements Externalizable {

    public Blip1() {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {

    Blip2() {
        System.out.println("Blip2.constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing Object");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects: ");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        ObjectInputStream i = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1:");
        b1 = (Blip1) i.readObject();
        System.out.println("Recovering b2:");
        b2 = (Blip2) i.readObject();
    }
}
