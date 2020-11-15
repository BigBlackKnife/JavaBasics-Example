package com.generics.building_complex_model;

import com.generics.method_generice.TupleTest2;
import com.generics.simple_generice.tuple.Amphibian;
import com.generics.simple_generice.tuple.Tuple4;
import com.generics.simple_generice.tuple.Vehicle;

import java.util.ArrayList;

/**
 * @author Blaife
 * @description 构建复杂模型 - 元组List
 * @date 2020/11/15 10:23
 */
public class TupleList<A,B,C,D> extends ArrayList<Tuple4<A,B,C,D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        tl.add(TupleTest2.h());
        tl.add(TupleTest2.h());
        for (Tuple4<Vehicle,Amphibian,String,Integer> i : tl) {
            System.out.println(i);
        }
    }

}
