package com.polymorphism.unit02turn.shape;

/**
 * @author Blaife
 * @description 多态 - 转机 - 产生正确行为 - 图行案例 - 正方形
 * @data 2020/5/16 21:56
 */
public class Square extends Shape {

    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square.erase()");
    }
}
