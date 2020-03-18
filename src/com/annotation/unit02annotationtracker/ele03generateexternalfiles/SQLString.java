package com.annotation.unit02annotationtracker.ele03generateexternalfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解定义 - 为修饰JavaBean域准备的注解(String)
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {

    int value() default 0;
    String name() default "";
    // 对constraints的嵌套使用
    Constraints constraints() default @Constraints;
}
