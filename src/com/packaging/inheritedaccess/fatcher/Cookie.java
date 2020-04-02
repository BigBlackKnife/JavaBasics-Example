package com.packaging.inheritedaccess.fatcher;

/**
 * @author Blaife
 * @description 案例 - 继承访问权限 - 基类
 * @data 2020/4/2 22:41
 */
public class Cookie {
    public Cookie() {
        System.out.println("Cookie constructor");
    }

    protected void bite() {
        System.out.println("bite");
    }
}
