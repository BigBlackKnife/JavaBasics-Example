package com.generics.erasure_generice.cpp_way;

/**
 * @author Blaife
 * @description C++方式
 *
 * 泛型只有在类型参数比某个具体类型（以及其子类）更加“泛化” 时才有用
 *
 * @date 2020/11/22 11:02
 */
public class Manipulation {

    public static void main(String[] args) {
        /*HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();*/
    }
}


class Manipulator<T> {

    private T obj;

    Manipulator(T x) {
        obj = x;
    }

    /**
     * 因为擦除，Java 编译器无法将 manipulate() 方法必须能调用 obj 的 f() 方法
     * 这一需求映射到 HasF 具有 f() 方法这个事实上。
     */
    public void manipulate() {
        /* obj.f(); */
    }
}

class Manipulator2<T extends HasF> {
    private T obj;

    Manipulator2(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}

class Manipulator3 {
    private HasF obj;

    Manipulator3(HasF x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}