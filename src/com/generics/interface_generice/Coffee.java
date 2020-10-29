package com.generics.interface_generice;

/**
 * @author Blaife
 * @description 接口泛型
 * @date 2020/10/29 22:09
 */
public class Coffee {

    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }


}
