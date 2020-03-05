package com.enumerated.unit07useinterfacestoorganize;

/**
 * 接口内部实现接口枚举
 *
 * 使用enum来表示不同种类的书屋，并且希望每个enum都是Food类型
 *
 * 对于enum而言，实现接口是使起子类化的唯一办法
 */
public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food {
        LASAGNE, BURRATO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
    }

    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}
