package com.exception.thinkingjava.customexception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 将日志构建在异常处理程序中
 */
public class LoggingExceptions2 {

    private static Logger logger = Logger.getLogger("LoggerException2");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }

}
