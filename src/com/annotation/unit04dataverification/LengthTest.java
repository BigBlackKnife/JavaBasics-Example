package com.annotation.unit04dataverification;

import java.util.logging.Logger;

/**
 * Length 注解测试
 * @author Blaife
 */
public class LengthTest {
    private static final Logger log = Logger.getLogger("Length");
    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student((long) 20160782, "Blaife", "18790675065");
        String message = LengthCommentProcessor.validate(student);
        if ("null".equals(message)) {
            log.info("没有错误信息");
        } else {
            log.warning(message);
        }
    }
}
