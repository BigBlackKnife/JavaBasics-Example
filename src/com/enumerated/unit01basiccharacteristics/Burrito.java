package com.enumerated.unit01basiccharacteristics;

import com.enumerated.Spiciness;
import static com.enumerated.Spiciness.*; // 导入静态包
/**
 * 静态导入用于enum
 * 引用静态包，即可使用枚举实例的标识符导入当前实例
 */
public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT)); // 使用枚举实例标识符
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
