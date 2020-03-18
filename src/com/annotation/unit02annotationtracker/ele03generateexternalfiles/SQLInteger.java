package com.annotation.unit02annotationtracker.ele03generateexternalfiles;

import java.lang.annotation.*;

/**
 * 注解定义 - 为修饰JavaBean域准备的注解(Integer)
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    String name() default "";
    Constraints constraints() default @Constraints;
}
