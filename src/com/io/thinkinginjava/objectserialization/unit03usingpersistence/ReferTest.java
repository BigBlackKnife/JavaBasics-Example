package com.io.thinkinginjava.objectserialization.unit03usingpersistence;

import java.io.*;

/**
 * 使用“持久化” -- 测试使对象序列化之后修该对象再次序列化到同一流
 * 取出的对象是修改前的内容
 */
class A implements Serializable {
    int a;
    B b;

    public A(int a, B b) {
        this.a = a;
        this.b = b;
    }
}

class B implements Serializable {
    int b;

    public B(int b) {
        this.b = b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }
}

public class ReferTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        B b = new B(2);
        A a = new A(1, b);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buf);
        out.writeObject(a);
        b.setB(3);
        out.writeObject(b);
        System.out.println(a.b.getB());
        System.out.println(buf.size());
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        A a2 = (A) in.readObject();
        System.out.println(a2.b.getB());
        B b2 = (B) in.readObject();
        System.out.println(b2.getB());

    }
}
