package com.io.thinkinginjava.objectserialization.unit03usingpersistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 使用“持久性” - 计算机辅助设计（CAD）系统
 */

/**
 * 形状（父类）
 */
abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;
    public abstract void setColor(int newColor);
    public abstract int getColor();
    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }
    @Override
    public String toString() {
        return getClass() + "Color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos +"] dim[" + dimension + "]\n";
    }

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
    }

    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0: return new Circle(xVal, yVal, dim);
            case 1: return new Square(xVal, yVal, dim);
            case 2: return new Line(xVal, yVal, dim);
        }
    }
}

/**
 * 圆（子类1）
 */
class Circle extends Shape {
    private static int color = RED;
    public Circle(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }
    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }
    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
    @Override
    public int getColor() {
        return color;
    }
}

/**
 * 正方形（子类三）
 */
class Square extends Shape {
    private static int color;
    public Square(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }
    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }
    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
    @Override
    public int getColor() {
        return color;
    }
}

/**
 * 线（子类3）
 */
class Line extends Shape {
    private static int color = RED;
    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }
    public Line(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }
    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
    @Override
    public int getColor() {
        return color;
    }
}

/**
 * 序列化static的值必须手动实现
 * 即serializeStaticState和deserializeStaticState方法
 * 序列化会将private数据保存下来，如xPos, yPos, dimension，安全考虑的话可以设置为transient
 */
public class StoreCADState {
    public static void main(String[] args) throws IOException {
        List<Shape> shapes = new ArrayList<>(); // 保存颜色
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }
        for (int i = 0; i < 10; i++) {
            shapes.get(i).setColor(Shape.GREEN);
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        Circle.serializeStaticState(out);
        Square.serializeStaticState(out);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        System.out.println(shapes);
    }

}
