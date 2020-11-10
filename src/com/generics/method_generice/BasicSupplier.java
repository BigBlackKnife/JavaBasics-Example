package com.generics.method_generice;

import java.util.function.Supplier;

/**
 * @author Blaife
 * @description 一个泛型的 Supplier
 * @date 2020/11/10 22:44
 */
public class BasicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public BasicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch (InstantiationException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}
