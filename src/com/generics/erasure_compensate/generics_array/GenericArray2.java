package com.generics.erasure_compensate.generics_array;

/**
 * @author Blaife
 * @description 创造一个被擦除类型的新数组，然后对其转型。
 * @date 2020/12/2 22:49
 */
public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array; // Unchecked cast
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai =
                new GenericArray2<>(10);
        for (int i = 0; i < 10; i++)
            gai.put(i, i);
        for (int i = 0; i < 10; i++)
            System.out.print(gai.get(i) + " ");
        System.out.println();
        try {
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
