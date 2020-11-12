package com.generics.method_generice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Blaife
 * @description Sets 表达数学中的关系式
 * @date 2020/11/12 22:01
 */
public class Sets {
    /**
     * 获取并集
     * @param a a
     * @param b b
     * @param <T> T
     * @return Set
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 获取交集
     * @param a a
     * @param b b
     * @param <T> T
     * @return Set
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 从超集中减去子集
     * @param superset superset
     * @param subset subset
     * @param <T> T
     * @return Set
     */
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }

    /**
     * 不在交集中的所有内容
     * @param a a
     * @param b b
     * @param <T> T
     * @return Set
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
