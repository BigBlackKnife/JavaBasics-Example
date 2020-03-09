package com.enumerated.unit10constantcorrelationmethod.ele02statemachinemodel;

import java.util.EnumMap;

import static com.enumerated.unit10constantcorrelationmethod.ele02statemachinemodel.Input.*;

/**
 * 使用enum的状态机 -- 自动售货机案例
 *
 * 商品分类枚举类
 */
public enum Category {
    // 可接收货币种类
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    // 可出售商品种类
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SOAP, SODA),
    // 放弃交易
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    // 关机
    SHUT_DOWN(STOP);

    // 存储分类对应的具体商品
    private Input[] vales;

    // 构造方法（多参数）
    Category(Input... types) {
        vales = types;
    }

    // 存储所选中的商品
    private static EnumMap<Input, Category> categories = new EnumMap<Input, Category>(Input.class);

    // 静态默认执行方法 将商品及分类存储起来
    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (Input type : c.vales) {
                categories.put(type, c);
            }
        }
    }

    // 输出方法 通过商品输出商品的分类
    public static Category categorize(Input input) {
        return categories.get(input);
    }

}
