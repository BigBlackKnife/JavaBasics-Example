package com.enumerated.unit03switcdemo;

/**
 * switch语句中使用enum
 * 一般来说switch中只能使用整数值，而枚举类型天生就具备整数值的次序
 */
enum Signal { GREEN, YELLOW, RED }

public class TrafficLight {
    Signal signal = Signal.RED;
    public void change() {
        switch (signal) {
            case RED:
                signal = Signal.GREEN;
                break;
            case GREEN:
                signal = Signal.YELLOW;
                break;
            case YELLOW:
                signal = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "the traffic light is " + signal;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
