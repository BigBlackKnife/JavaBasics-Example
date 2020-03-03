package com.enumerated;

/**
 * enum + switch == 绝佳的组合
 */
public class Burrito {

    Spiciness spiciness;

    public Burrito(Spiciness spiciness) {
        this.spiciness = spiciness;
    }

    public void describe() {
        System.out.print("This burrio is ");
        switch (spiciness) {
            case NOT:
                System.out.println("not spicy at all.");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little hot.");
                break;
            case HOT:
            case FLAMING:
            default:
                System.out.println("maybe too hot.");
        }
    }

    public static void main(String[] args) {
        // 使用enum时，创建一个该类型的引用，并将值赋给某个实例
        Burrito plain = new Burrito(Spiciness.NOT),
                greenChile = new Burrito(Spiciness.MEDIUM),
                jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        greenChile.describe();
        jalapeno.describe();
    }
}
/*
    This burrio is not spicy at all.
    This burrio is a little hot.
    This burrio is maybe too hot.
 */