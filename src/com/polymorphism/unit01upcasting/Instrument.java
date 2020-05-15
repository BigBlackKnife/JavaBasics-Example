package com.polymorphism.unit01upcasting;

/**
 * @author Blaife
 * @description 多态 - 再论向上转型 - 乐器案例 - 乐器超类
 * @data 2020/5/15 20:15
 */
public class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}

/**
 * 吹奏乐器
 */
class Wind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}

/**
 * 弦乐
 */
class Stringed extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }
}

/**
 * 管乐
 */
class Brass extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }
}