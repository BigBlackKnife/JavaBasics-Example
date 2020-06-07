package com.polymorphism.unit02turn.shape;

/**
 * @author Blaife
 * @description 多态 - 转机 - 产生正确行为 - 图行案例 - 测试类（执行draw）
 * @data 2020/5/16 22:20
 */
public class Shapes {

    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        for (int i = 0; i < s.length; i++) {
            s[i] = gen.next();
        }
        for (Shape shp : s) {
            shp.draw();
        }
    }

}
