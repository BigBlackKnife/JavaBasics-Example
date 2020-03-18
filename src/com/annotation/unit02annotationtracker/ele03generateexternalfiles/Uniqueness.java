package com.annotation.unit02annotationtracker.ele03generateexternalfiles;

/**
 * 注解定义 - 为修饰JavaBean域准备的注解(非空判定)
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
