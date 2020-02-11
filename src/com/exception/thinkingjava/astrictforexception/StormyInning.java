package com.exception.thinkingjava.astrictforexception;

/**
 * 异常的限制
 */

class BaseballException extends Exception {};
class Foul extends BaseballException {};
class Strike extends BaseballException {};

abstract class Inning {

    public Inning() throws BaseballException {}

    public void event() throws BaseballException {
        // Doesn't actually have to throw anything
        // 实际上，你不需要抛出任何东西
    };

    public abstract void atBat() throws Strike, Foul;

    public void walk() {} // 抛出未检查异常
}

class StormException extends Exception {};

class RainedOut extends StormException {};

class Popfoul extends Foul {};

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws Foul, RainedOut;
}

// 限制一：抽象类和接口中都有event方法，接口中的方法不能改变抽象类中event方法的异常接口
public class StormyInning extends Inning implements Storm {

    // 限制二：异常限制对构造器不起作用（可以抛出任意异常），但派生类构造器的异常说明必须包含基类构造器的异常说明
    // 派生类构造器不能捕获基类构造器抛出的异常
    public StormyInning() throws RainedOut, BaseballException {}
    public StormyInning(String s) throws Foul, BaseballException {}

    @Override
    public void atBat() throws Popfoul {}

    @Override
    public void rainHard() throws RainedOut {}

    // 限制三：编译失败原因时inning类中未声明此异常，抛出此异常会导致程序失灵
    /*@Override
    public void walk() throws Popfoul {
        super.walk();
    }*/

    // 限制四：派生类方法可以不抛出任何异常，即使时基类中包含的异常
    @Override
    public void event() {}

    // 限制五：处理派生类时只会强制要求你捕获这个类所抛出的异常
    // 如果将它向上转为基类型，那么编译器就会要求你捕获基类异常

    // 限制六：异常说明本身并不属于方法类型的一部分，因此，不能基于异常说明来重载方法
    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (Popfoul popfoul) {
            popfoul.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Foul foul) {
            foul.printStackTrace();
        } catch (Strike strike) {
            strike.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        }

    }
}
