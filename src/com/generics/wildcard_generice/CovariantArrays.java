package com.generics.wildcard_generice;

/**
 * @author Blaife
 * @description TODO
 * @date 2021/1/25 22:23
 */
class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

public class CovariantArrays {

    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        // Contents of array 'fruit' are written to, but never read
        // 数组“ fruit”的内容已写入，但从未读取
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        // Compile Error: incompatible types:
        // List<Fruit> flist = new ArrayList<Apple>();
    }
}
/* Output:
java.lang.ArrayStoreException: com.generics.wildcard_generice.Fruit
java.lang.ArrayStoreException: com.generics.wildcard_generice.Orange
*///:~