package com.exception.thinkingjava.withfinally;

/**
 * 案例说明：程序结束时开关必须是关闭状态。
 * """"""""""""""""""""""""将资源恢复到它的初始状态""""""""""""""""""""""""
 * 如下案例，如果没有finally块，则关闭开关则需要在每一个try或catch块中都写一遍。
 */
public class OnOffSwitch {

    private static Switch sw = new Switch();

    public static void f() throws OnOffException1,OnOffException2 {};

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            sw.off();
        } catch (OnOffException1 onOffException1) {
            onOffException1.printStackTrace();
            sw.off();
        } catch (OnOffException2 onOffException2) {
            onOffException2.printStackTrace();
            sw.off();
        }
    }

}
