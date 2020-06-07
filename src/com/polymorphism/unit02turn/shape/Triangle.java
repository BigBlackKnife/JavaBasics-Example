package com.polymorphism.unit02turn.shape;

/**
 * @author Blaife
 * @description 多态 - 转机 - 产生正确行为 - 图行案例 - 三角形
 * @data 2020/5/16 22:17
 */
public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }
}
