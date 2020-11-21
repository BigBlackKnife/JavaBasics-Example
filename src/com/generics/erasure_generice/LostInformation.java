package com.generics.erasure_generice;

import java.util.*;

/**
 * @author Blaife
 * @description 获取 TypeVariable 对象数组
 *      只能看到用作参数占位符的标识符
 *      在泛型代码内部，无法获取任何有关泛型参数类型的信息。
 * @date 2020/11/21 19:39
 */


class Frob {}
class Fnorkle {}
class Quark<Q> {}

class Particle<POSITION, MOMENTUM> {}

public class LostInformation {

    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }

}
