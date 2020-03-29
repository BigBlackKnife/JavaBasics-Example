package com.initializationandcleanup.finishcondition;

/**
 * 终结条件案例
 * @author Blaife
 * @date 2020-03-29
 */
public class Book {
    boolean checkedOut = false;

    public Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    /**
     * 垃圾回收方法
     */
    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
        // 原方法内容，应该总是假设基类版本中的finalize()方法也要做某些重要的东西
        super.finalize();
    }

}
