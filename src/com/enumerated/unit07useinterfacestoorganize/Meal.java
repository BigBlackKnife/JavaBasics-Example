package com.enumerated.unit07useinterfacestoorganize;

/**
 * 枚举的枚举 -- 测试方法
 * 随机的选取一个Food
 *
 * 如果这时候想通过Course取到一个值 比如SALAD 应该如何去做,
 * 我们可以处理values，他是一个实例化的数组，虽然不能对kind使用.获取实例，但可以对values[]通过下标获取实例
 */
public class Meal {

    public static void main(String[] args) {
        // 输出指定实例 如SALAD，
        System.out.println(Course.APPETIZER.getEnumByIndex(0));

        /**
         * 随机选取
         */
        for (int i = 0; i < 5; i++) {
            System.out.println("------------------------menu "+ (i+1) +":-------------------------");
            for (Course course: Course.values()) {
                System.out.println(course.randomSelection());
            }
        }
    }

}
