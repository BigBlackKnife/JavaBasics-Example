package com.enumerated.unit10constantcorrelationmethod;

/**
 * 我们并不能真的把enum实例作为一个classes类型来使用
 * 因为每个enum实例都是LikeClasses类型的static final实例, 所以无法访问外部类的非static元素和方法
 */
public enum  LikeClasses {

    WINKEN{
        @Override
        void behavior() {
            System.out.println("behavior1");
        }
    },
    BLINKEN{
        @Override
        void behavior() {
            System.out.println("behavior2");
        }
    },
    WOD{
        @Override
        void behavior() {
            System.out.println("behavior3");
        }
    };

    abstract void behavior();

    public class NotClasses {
        // void f1(LikeClasses.WOD instance){};
    }

}
