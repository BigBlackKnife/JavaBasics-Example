package com.io.thinkinginjava.objectserialization.unit03usingpersistence;

import java.io.*;
import java.util.List;

/**
 * 使用“持久性” - 计算机辅助涉及（CAD）系统
 */
public class RecoverCADState {
    @SuppressWarnings("all")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        Circle.deserializeStaticState(in);
        Square.deserializeStaticState(in);
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}
