package com.generics.method_generice;

import java.util.EnumSet;
import java.util.Set;

import static com.generics.method_generice.Sets.*;
import static com.generics.method_generice.Watercolors.*;

/**
 * @author Blaife
 * @description 从 enum 中创建 Set
 * @date 2020/11/12 22:07
 */
public class WatercolorSets {

    public static void main(String[] args) {
        // 静态方法 EnumSet.range() 要求提供所要在结果 Set 中创建的元素范围的第一个和最后一个元素：
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        System.out.println("intersection(set1, set2): " + subset);
        System.out.println("difference(set1, subset): " + difference(set1, subset));
        System.out.println("difference(set2, subset): " + difference(set2, subset));
        System.out.println("complement(set1, set2): " + complement(set1, set2));
    }

}
