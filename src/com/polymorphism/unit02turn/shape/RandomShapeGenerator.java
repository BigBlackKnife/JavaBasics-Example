package com.polymorphism.unit02turn.shape;

import java.util.Random;

/**
 * @author Blaife
 * @description 多态 - 转机 - 产生正确行为 - 图行案例 - 获取随机图形
 * @data 2020/5/16 22:18
 */
public class RandomShapeGenerator {

    private Random rand = new Random(47);
    public Shape next() {
        switch (rand.nextInt(3)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }

}
