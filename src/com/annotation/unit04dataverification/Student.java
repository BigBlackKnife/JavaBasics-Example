package com.annotation.unit04dataverification;


/**
 * 实体类 -- 测试Length注解的使用情况
 * @author blaife --> (CodeSheep)
 */
public class Student {
    /**
     * 学号
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    @Length(min = 11, max = 11, errorMsg = "电话号码的长度必须是11位")
    private String mobile;

    public Student(Long id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

}
