package com.generics.building_complex_model;

import com.generics.Suppliers;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author Blaife
 * @description 一个具有过道，货架和产品的零售商店
 * @date 2020/11/15 11:15
 */

/**
 * 商品
 */
class Product {
    private final int id;
    private String description;
    private double price;

    Product(int idNumber, String descr, double price) {
        id = idNumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    /**
     * 价格变动
     * @param change 变动数量
     */
    public void priceChange(double change) {
        price += change;
    }

    /**
     * 使用生成器 生成product
     */
    public static Supplier<Product> generator = new Supplier<Product>() {
        private Random rand = new Random(47);

        @Override
        public Product get() {
            return new Product(rand.nextInt(1000), "Test",
                    Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };

}

/**
 * 货架
 */
class Shelf extends ArrayList<Product> {
    Shelf(int nProducts) {
        Suppliers.fill(this, Product.generator, nProducts);
    }
}

/**
 * 走廊
 */
class Aisle extends ArrayList<Shelf> {
    Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}

/**
 * 收银台
 */
class CheckoutStand {}


/**
 * 商店
 */
public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();

    /**
     * 商店初始化方法
     * @param nAisles 走廊
     * @param nShelves 货架
     * @param nProducts 商品
     */
    public Store(int nAisles, int nShelves, int nProducts) {
        for (int i = 0; i < nAisles; i++)
            add(new Aisle(nShelves, nProducts));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle a : this)
            for (Shelf s : a)
                for (Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(5, 4, 3));
    }
}