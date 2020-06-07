package com.polymorphism.unit02turn.shape;

/**
 * @author Blaife
 * @description 多态 - 转机 - 产生正确行为 - 图行案例 - 圆
 * @data 2020/5/16 21:51
 */
public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }
}
