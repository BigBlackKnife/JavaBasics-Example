package com.operationalcharacter.autoincrementdecrement;

/**
 * @author Blaife
 * @description 自动递增递减 - 取值问题
 * @data 2020/4/29 20:28
 */
public class ValueProblem {

    public static void main(String[] args) {
        int i = 1;
        // 执行这一步 i值不变 依旧为1
        /* 具体执行过程为：
         * int temp = 0; //表达式的值，先保存起来
         * i++; //i自增
         * i = temp; //表达式的值赋值给i
         */
        // 《java解惑》谜题25 ： 在一个表达式中，对一个变量的赋值超过一次。这样极易导致误解和错误
        i = i++;
        // 执行完此行后 j = 1; i = 2
        int j = i++;
        // 从左到右执行。
        // k = 2 + 3 * 3 = 11;
        // 确定值的先保存起来，自递增递减的不会影响到之前确定的值。
        int k = i + ++i * i++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
    }

}
