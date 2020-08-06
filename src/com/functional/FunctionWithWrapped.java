package com.functional;

import java.util.function.*;

/**
 * @author Blaife
 * @description 使用包装类型
 * @data 2020/8/6 22:48
 */
public class FunctionWithWrapped {

    public static void main(String[] args) {
        Function<Integer, Double> fid = i -> (double)i;
        System.out.println(fid.apply(1));
        IntToDoubleFunction fid2 = i -> i;
        System.out.println(fid2.applyAsDouble(1));
    }

}
