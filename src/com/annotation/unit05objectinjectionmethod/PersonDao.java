package com.annotation.unit05objectinjectionmethod;

import java.beans.IntrospectionException;

/**
 * @author Blaife
 * @description 拥有person对象以及get、set方法【属性及方法注入Person】
 * @data 2020/5/2 22:40
 */
public class PersonDao {
    @InjectPerson(name = "wenjiu",age = 20)
    Person person;

    public Person getPerson() {
        return person;
    }

    @InjectPerson(name = "blaife", age = 23)
    public void setPerson(Person person) {
        this.person = person;
    }

}
