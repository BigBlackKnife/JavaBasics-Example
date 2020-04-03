package com.reuse.combination;

/**
 * @author Blaife
 * @description 复用 - 组合语法
 * @data 2020/4/3 22:11
 */
class Soap {
    private String s;
    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }
    @Override
    public String toString() { return s; }
}

/**
 * @author Blaife
 */
public class Bath {
    /**
     * 1。 在定义点初始化 -- 在定义对象的位置
     */
    private String  s1 = "Happy", s2 = "Happy", s3, s4;
    private Soap castille;
    private int i;
    private float toy;
    public Bath() {
        System.out.println("Inside Bath()");
        // 2. 在类的构造器中进行初始化
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }
    // 3. 实例初始化
    { i = 47; }
    @Override
    public String toString() {
        // 4. 延迟初始化 -- 在生成对象之前
        if(s4 == null) {
            s4 = "Joy";
        }
        return "s1 = " + s1 + "\n" +
            "s2 = " + s2 + "\n" +
            "s3 = " + s3 + "\n" +
            "s4 = " + s4 + "\n" +
            "i = " + i + "\n" +
            "toy = " + toy + "\n" +
            "castille = " + castille;
    }
    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }
}
