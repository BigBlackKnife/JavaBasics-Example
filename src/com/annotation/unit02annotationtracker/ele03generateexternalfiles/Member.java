package com.annotation.unit02annotationtracker.ele03generateexternalfiles;

/**
 * 简单bean定义 一个数据表
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    // 最好的方法是：每种类型特性使用一个注解，公共特性使用一个注解
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    public String getHandle() {
        return handle;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getAge() {
        return age;
    }
    @Override
    public String toString() {
        return handle;
    }

}
