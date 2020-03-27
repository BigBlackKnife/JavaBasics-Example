package com.annotation.unit04dataverification;

import java.lang.reflect.Field;

/**
 * 长度验证的注解处理器，利用反射原理
 * @author blaife --> (CodeSheep)
 */
public class LengthCommentProcessor {
    public static String validate(Object object) throws IllegalAccessException {
        // 首先通过反射获取Object对象的类有哪些字段
        // 对文本来说就可以获取到Student类的id,name,mobile三个字段
        Field[] fields = object.getClass().getDeclaredFields();

        // 逐个字段校验，查看是否使用了注解
        for ( Field field: fields) {
            // if判断： 如果其使用了注解@Length
            if (field.isAnnotationPresent(Length.class)) {
                // 通过反射获取到该字段的Length注解的详细信息
                Length length = field.getAnnotation(Length.class);
                // 这样我们就可以在反射时访问私有变量
                field.setAccessible(true);
                // 通过反射获取字段实际值
                int value = ((String)field.get(object)).length();
                // 将字段的实际值和注解上的做标识的值进行对比
                if (value < length.min() || value > length.max()) {
                    return length.errorMsg();
                }
            }
        }
        return null;
    }
}
