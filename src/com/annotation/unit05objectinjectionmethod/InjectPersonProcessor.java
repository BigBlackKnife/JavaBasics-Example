package com.annotation.unit05objectinjectionmethod;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Blaife
 * @description InjectPerson 注解的处理器
 * @data 2020/5/2 22:45
 */
public class InjectPersonProcessor {

    /**
     * 注入对象到方法上
     */
    public static void injectPersonForMethod() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // 1. 使用内省【后边需要得到属性的写方法】，得到想要注入的属性
        PropertyDescriptor descriptor = new PropertyDescriptor("person", PersonDao.class);

        // 2. 得到想要注入属性的具体对象【注意：Person类中必须有无参构造方法】
        Person person = (Person) descriptor.getPropertyType().newInstance();

        // 3. 得到该对象的写方法【setPerson】
        Method method = descriptor.getWriteMethod();

        // 4. 得到写方法的注解
        InjectPerson annotation = method.getAnnotation(InjectPerson.class);

        // 5. 得到注解上的信息
        Method[] methods = annotation.getClass().getMethods();

        // 6. 将注解信息填充到person对象上
        for (Method m : methods) {

            // 得到注解上的名字  name或age
            String name = m.getName();

            try {
                // 假设与之对应的写方法，得到写方法
                PropertyDescriptor personDescript = new PropertyDescriptor(name, Person.class);
                Method personWriteMethod = personDescript.getWriteMethod();

                // 得到注解中的值
                Object o = m.invoke(annotation, null);

                // 调用person的setter方法，将注解上的值设置出去
                personWriteMethod.invoke(person, o);

                // 注意这里的Exception, 应为有可能出现InvocationTargetException 和 IntrospectionException
            }  catch (IntrospectionException | InvocationTargetException e) {
                continue;
            }
        }

        // 7. 将person对象赋给Person【通过写方法】
        PersonDao personDao = new PersonDao();
        method.invoke(personDao, person);

        System.out.println(personDao.getPerson());
    }

    /**
     * 注入对象到成员变量上
     */
    public static void injectPersonForField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 1. 得到想要注入的属性
        Field field = PersonDao.class.getDeclaredField("person");

        // 2. 得到属性的具体对象
        Person person = (Person) field.getType().newInstance();

        // 3. 得到属性上的注解
        InjectPerson annotation = field.getAnnotation(InjectPerson.class);

        // 4. 得到注解的属性[注解上的属性使用方法是用表示的]
        Method[] methods = annotation.getClass().getMethods();

        // 5.将注入的属性填充到person对象上
        for (Method m : methods) {

            // 得到注解属性的名字
            String name = m.getName();

            try {
                // 假设与之对应的写方法，得到写方法
                PropertyDescriptor descriptor = new PropertyDescriptor(name, Person.class);
                Method personWriteMethod = descriptor.getWriteMethod();

                // 得到注解中的值
                Object o = m.invoke(annotation, null);

                //填充person对象
                personWriteMethod.invoke(person, o);

            } catch (IntrospectionException | InvocationTargetException e) {
                continue;
            }

        }

        // 6. 把person对象设置到PersonDao中
        PersonDao personDao = new PersonDao();
        field.setAccessible(true);
        field.set(personDao, person);

        System.out.println(personDao.getPerson());
    }
}
