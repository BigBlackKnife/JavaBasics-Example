package com.initializationandcleanup.finishcondition;

/**
 * 终结条件案例
 * @author Blaife
 * @date 2020-03-29
 */
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        // 运行垃圾回收器
        new Book(true);
        System.gc();
    }
}
