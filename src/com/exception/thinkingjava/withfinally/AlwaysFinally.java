package com.exception.thinkingjava.withfinally;

class FourException extends Exception{};

/**
 * 在异常没有被当前的异常处理程序捕获的情况下，异常处理机制也会在跳到更高一层的异常处理程序之前执行。
 * 当涉及break和continue时，finally子句也会得到执行。
 */
public class AlwaysFinally {

    public static void main(String[] args) {
        System.out.println("Entering first try block");
        try {
            System.out.println("Entering second try block");
            try {
                throw new FourException();
            } finally {
                System.out.println("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1nd try block");
        }
    }
}
