package com.io.thinkinginjava.objectserialization.unit02serializationcontrol;

import java.io.*;

/**
 * Externalizable的替代方法
 * Serializable对象添加writeObject，readObject，序列化与反序列化的时候自动调用这两个方法
 */
public class SerialCtl implements Serializable {

    private String a;
    private transient String b;

    public SerialCtl(String a, String b) {
        this.a = "Not transient: " + a;
        this.b = "transient:" + b;
    }

    @Override
    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject(); // 写入非transient部分
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject(); // 读取非transient部分
        b = (String)stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream buf = new ByteArrayOutputStream(); // 存储空间


        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before:\n" + sc);
        ObjectOutputStream out = new ObjectOutputStream(buf);
        out.writeObject(sc);

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("After:\n" + sc2);
    }

}
