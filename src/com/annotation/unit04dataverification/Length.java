package com.annotation.unit04dataverification;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据长度校验注解
 * @author blaife --> (CodeSheep)
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    // 允许的最小长度
    int min();
    // 允许的最大长度
    int max();
    // 自定义错误提示信息
    String errorMsg();
}
