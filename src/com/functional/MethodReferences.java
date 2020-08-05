package com.functional;

/**
 * @author Blaife
 * @description 方法引用的组成
 * @date 2020/8/4 23:25
 */
interface Callable { // [1] 我们从单一方法接口开始
	void call(String s);
}

class Describe {
	void show(String msg) { // [2] show() 的签名（参数类型和返回类型）符合 Callable 的 call() 的签名。
		System.out.println(msg);
	}
}

public class MethodReferences {
	static void hello(String name) { // [3] hello() 也符合 call() 的签名。
		System.out.println("Hello, " + name);
	}

	static class Description {
		String about;

		Description(String desc) {
			about = desc;
		}

		void help(String msg) { // [4] help() 也符合，它是静态内部类中的非静态方法。
			System.out.println(about + " " + msg);
		}
	}

	static class Helper {
		static void assist(String msg) { // [5] assist() 是静态内部类中的静态方法。
			System.out.println(msg);
		}
	}

	public static void main(String[] args) {
		Describe d = new Describe();
		Callable c = d::show; // [6] 我们将 Describe 对象的方法引用赋值给 Callable ，它没有 show() 方法，
		// 而是 call() 方法。 但是，Java 似乎接受用这个看似奇怪的赋值，因为方法引用符合 Callable 的 call() 方法的签名。
		c.call("call()"); // [7] 我们现在可以通过调用 call() 来调用 show()，因为 Java 将 call() 映射到 show()。

		c = MethodReferences::hello; // [8] 这是一个静态方法引用。
		c.call("Bob");

		c = new Description("valuable")::help; // [9] 这是 [6] 的另一个版本：对已实例化对象的方法的引用，有时称为绑定方法引用。
		c.call("information");

		c = Helper::assist; // [10] 最后，获取静态内部类的方法引用的操作与 [8] 中外部类方式一样。
		c.call("Help!");
	}
}