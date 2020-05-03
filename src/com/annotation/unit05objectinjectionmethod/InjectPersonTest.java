package com.annotation.unit05objectinjectionmethod;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Blaife
 * @description 注入对象到方法或成员变量上的测试类
 * @data 2020/5/3 16:22
 */
public class InjectPersonTest {
    public static void main(String[] args) throws InvocationTargetException, IntrospectionException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        InjectPersonProcessor.injectPersonForMethod();

        InjectPersonProcessor.injectPersonForField();

    }
}
