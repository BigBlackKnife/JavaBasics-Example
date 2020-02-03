package com.exception.thinkingjava.withfinally;

/**
 * 开关，案例主类OnOffSwitch所需组件类。
 * 单属性state：状态
 * 三个方法，读以及打开和关闭。
 * 重写了toString方法
 */
public class Switch {

    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "on" : "off";
    }
}
