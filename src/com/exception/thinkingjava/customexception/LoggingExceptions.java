package com.exception.thinkingjava.customexception;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception {
    // 创建日志对象并设置 日志记录器名称为LoggingException
    private static Logger logger = Logger.getLogger("LoggingException");

    // 构造方法
    public LoggingException() {
        StringWriter trace = new StringWriter(); // 字符串输出类
        printStackTrace(new PrintWriter(trace)); // 写入内容
        logger.severe(trace.toString()); // 日志对象执行（输出日志内容）
    }
}

/**
 * 自定义异常记录日志
 */
public class LoggingExceptions {

    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }

        /*try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }*/
    }

}
