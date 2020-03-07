package com.enumerated.unit10constantcorrelationmethod;

import java.time.LocalDateTime;

/**
 * 常量相关方法
 * 通过为enum定义一个或多个abstract方法，并为实例实现这些方法
 * 这通常被称为`表驱动代码`， 与命令方式比较相似
 */
public enum ConstantSpecificMethod {
    DATE_TIME{
        @Override
        String getInfo() {
            return LocalDateTime.now().toString();
        }
    },
    CLASSPATH{
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }
}
