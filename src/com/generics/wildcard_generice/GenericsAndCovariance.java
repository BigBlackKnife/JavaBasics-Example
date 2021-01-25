package com.generics.wildcard_generice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Blaife
 * @description TODO
 * @date 2021/1/25 22:37
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<>();
        // Compile Error: can't add any type of object:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // Legal but uninteresting
        // We know it returns at least Fruit:
        Fruit f = flist.get(0);

        List<? extends Fruit> flist2 = new ArrayList<Apple>();
    }
}
