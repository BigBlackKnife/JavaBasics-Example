package com.polymorphism.unit01upcasting;

/**
 * @author Blaife
 * @description 多态 - 再论向上转型 - 乐器案例 - 演奏类
 * @data 2020/5/15 20:18
 */
public class Music {
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}
