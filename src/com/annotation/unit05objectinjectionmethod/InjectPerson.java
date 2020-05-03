package com.annotation.unit05objectinjectionmethod;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注入Person对象的注解
 * @author blaife
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPerson {

    String name();
    int age();

}
