package com.functional;

/**
 * @author Blaife
 * @description 未绑定的方法引用
 * @date 2020/8/4 23:25
 */
class X {
	String f() {
		return "X::f()";
	}
}

interface MakeString {
	String make();
}

interface TransformX {
	String transform(X x);
}

public class UnboundMethodReference {
	public static void main(String[] args) {
		// MakeString ms = X::f; // [1] 不能在没有 X 对象的前提下调用 f()
		TransformX sp = X::f;
		X x = new X();
		System.out.println(sp.transform(x)); // [2] 我拿到未绑定的方法引用，并且调用它的transform()方法，
		// 将一个X类的对象传递给它，然后就以某种方式导致了对 x.f() 的调用。
		System.out.println(x.f()); // 同等效果
	}
}