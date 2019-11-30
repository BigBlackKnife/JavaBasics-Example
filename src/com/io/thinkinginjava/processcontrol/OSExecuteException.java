package com.io.thinkinginjava.processcontrol;

/**
 * 进程控制 -- 自定义异常类
 */
public class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why) {
        super(why);
    }
}
