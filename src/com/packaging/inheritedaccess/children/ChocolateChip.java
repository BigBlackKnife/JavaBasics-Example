package com.packaging.inheritedaccess.children;

import com.packaging.inheritedaccess.fatcher.Cookie;

/**
 * @author Blaife
 * @description 案例 - 继承访问权限 - 子类
 * @data 2020/4/2 22:42
 */
public class ChocolateChip extends Cookie {

    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }

    public void chomp() {
        bite();
    }
}
