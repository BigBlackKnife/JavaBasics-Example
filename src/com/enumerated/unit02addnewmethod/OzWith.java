package com.enumerated.unit02addnewmethod;

/**
 * 添加新方法 -- 描述信息
 * 枚举类不能被继承，但是可以添加方法，可以有main()方法
 */
public enum OzWith {
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private String description;

    /**
     * 构造器 -- 专门处理额外信息
     * 枚举类中的构造方法略有不同 -- 参数值即为enum实例后的参数（他们之间会一一对应）
     * @param description
     */
    OzWith(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWith witch : OzWith.values()) {
            System.out.println(witch + ":" + witch.getDescription());
        }
    }
}
