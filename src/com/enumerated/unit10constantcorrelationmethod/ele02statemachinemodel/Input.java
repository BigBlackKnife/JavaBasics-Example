package com.enumerated.unit10constantcorrelationmethod.ele02statemachinemodel;

import java.util.Random;

/**
 * 使用enum的状态机 -- 自动售货机案例
 *
 * 可接受钞票以及可出售商品 枚举类
 */
public enum Input {
    // 5美分
    NICKEL(5),
    // 10美分
    DIME(10),
    // 25美分
    QUARTER(25),
    // 1美元元
    DOLLAR(100),

    // 牙膏 2美元
    TOOTHPASTE(200),
    // 薯条 75美分
    CHIPS(75),
    // 苏打水 1美元
    SODA(100),
    // 肥皂 50美分
    SOAP(50),

    // 终止
    ABORT_TRANSACTION {
        @Override
        int amount() {
            throw new RuntimeException("ABORT.amount");
        }
    },

    // 关机
    STOP {
        @Override
        int amount() {
            throw new RuntimeException("SHUT_DOWN.amount");
        }
    };

    // 价格
    int value;

    // 构造方法
    Input(int value) {
        this.value = value;
    }

    // 构造方法
    Input() {};

    int amount() {
        return value;
    }

    static Random rand = new Random(47);

    // 随机选择enum实例
    public static Input randonSelection() {
        return values()[rand.nextInt(values().length - 1)];
    }
}
