package com.io.thinkinginjava.objectserialization.unit02serializationcontrol;

import java.io.*;

/**
 * 完整的保存和恢复一个Externalizable对象
 * 没有任何默认行为来为Externalizable对象写入任何成员对象
 * 我们需要调用基类版本的writeExternal和readExternal来为基类组件提供恰当的存储和恢复功能
 */
public class Blip3 implements Externalizable {

    private int i;
    private String s;

    public Blip3() {
        System.out.println("Blip3 Constructor");
    }

    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        // 默认构造器中不进行对s.i的初始化，假如注释掉以下两行，则s位null，i位0
        s = (String)in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip3 b3 = new Blip3("A String", 47);
        System.out.println(b3);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving object:");
        out.writeObject(b3);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.println("Recovering b3:");
        b3 = (Blip3) in.readObject();
        System.out.println(b3);
    }
}
