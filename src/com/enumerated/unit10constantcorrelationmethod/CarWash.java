package com.enumerated.unit10constantcorrelationmethod;

import java.util.EnumSet;

/**
 * enum常量方法比匿名内部类相比更加高效，简洁。
 *
 * EnumSet：
 *      同一个元素只能出现一次
 *      enum实例定义是的次序决定了其输出顺序
 */
public class CarWash {

    public enum Cycle {

        UNDERBOOY {
            @Override
            void action() {
                System.out.println("Spraying the underbody");
            }
        },
        WHEELWASH {
            @Override
            void action() {
                System.out.println("Washing the wheels");
            }
        },
        BASIC {
            @Override
            void action() {
                System.out.println("The basic wash");
            }
        },
        HOTWAX {
            @Override
            void action() {
                System.out.println("Applying hot wax");
            }
        },
        RINSE {
            @Override
            void action() {
                System.out.println("Rising");
            }
        },
        BLOWDRY {
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.noneOf(Cycle.class);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void washCar() {
        for (Cycle c : cycles) {
            c.action();
        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println(carWash);
        carWash.add(Cycle.BLOWDRY);
        carWash.add(Cycle.BLOWDRY);
        carWash.add(Cycle.HOTWAX);
        carWash.add(Cycle.UNDERBOOY);
        System.out.println(carWash);
        carWash.washCar();
    }
}
