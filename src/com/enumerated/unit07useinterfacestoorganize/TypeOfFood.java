package com.enumerated.unit07useinterfacestoorganize;
import static com.enumerated.unit07useinterfacestoorganize.Food.*;

/**
 * 接口内部实现接口枚举 -- 测试
 *
 * 注意引用了import static com.enumerated.unit07useinterfacestoorganize.Food.*; 即静态导入。
 * 如果不引用应该写为Food food = Food.Appetizer.SALAD;
 */
public class TypeOfFood {

    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = Coffee.CAPPUCCINO;
        food = Dessert.FRUIT;
        food = MainCourse.LENTILS;
    }

}
