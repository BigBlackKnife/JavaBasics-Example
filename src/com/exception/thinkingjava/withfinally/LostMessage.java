package com.exception.thinkingjava.withfinally;

/**
 * 缺憾：异常丢失
 * 用某些特殊的方式使用finally子句，会出现异常丢失的情况
 *
 * 输出情况：
 * A trivial exception!!!
 *
 * 可以看到VeryImportantException不见了。它被finally子句中的HoHumException所取代
 */

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!!!";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception!!!";
    }
}

public class LostMessage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                lm.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
