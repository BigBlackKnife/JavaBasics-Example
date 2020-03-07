package com.enumerated.unit10constantcorrelationmethod;

/**
 * 除了实现abstract方法外 还可以覆盖常量相关的方法
 */
public enum OverrideConstantSpecific {

    NUT, BOLT,
    WASHER {
        @Override
        void f() {
            System.out.println("Overridden method");
        }
    };

    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific o : values()) {
            o.f();
        }
    }
}
