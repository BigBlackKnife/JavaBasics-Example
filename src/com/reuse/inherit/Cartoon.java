package com.reuse.inherit;

/**
 * @author Blaife
 * @description 复用 - 继承语法
 * @data 2020/4/3 22:18
 *
 * Output:  构造从基类“向外”进行
 * Art constructor
 * Drawing constructor
 * Cartoon constructor
 *
 */
public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon constructor");
    }
    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}

class Art {
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor");
    }
}