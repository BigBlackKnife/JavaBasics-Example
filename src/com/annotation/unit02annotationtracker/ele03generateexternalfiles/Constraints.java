package com.annotation.unit02annotationtracker.ele03generateexternalfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解定义 - 为修饰JavaBean域准备的注解（基本约束）
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    // 主键约束
    boolean primaryKey() default false;
    // 允许为空
    boolean allowNull() default true;
    // 允许重复
    boolean unique() default false;
}
