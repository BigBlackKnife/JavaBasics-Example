package com.functional;

interface Strategy {
	String approach(String msg);
}

class Soft implements Strategy {
	@Override
	public String approach(String msg) {
		return msg.toLowerCase() + "?";
	}
}

class Unrelated {
	static String twice(String msg) {
		return msg + " " + msg;
	}
}

public class Strategize {
	Strategy strategy;
	String msg;

	Strategize(String msg) {
		strategy = new Soft(); // [1] 在 Strategize 中，Soft 作为默认策略，在构造函数中赋值。
		this.msg = msg;
	}

	void communicate() {
		System.out.println(strategy.approach(msg));
	}

	void changeStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public static void main(String[] args) {
		Strategy[] strategies = { new Strategy() { // [2] 一种略显简短且更自发的方法是创建一个匿名内部类。即使这样，仍有相当数量的冗余代码。
			public String approach(String msg) {
				return msg.toUpperCase() + "!";
			}
		}, msg -> msg.substring(0, 5), // [3] Java 8 的 Lambda 表达式。由箭头 -> 分隔开参数和函数体，箭头左边是参数，箭头右侧是从 Lambda 返回的表达式，即函数体。这实现了与定义类、匿名内部类相同的效果，但代码少得多.
				Unrelated::twice // [4] Java 8 的方法引用，由 :: 区分。在 :: 的左边是类或对象的名称，在 :: 的右边是方法的名称，但没有参数列表
		};
		Strategize s = new Strategize("Hello there");
		s.communicate();
		for (Strategy newStrategy : strategies) {
			s.changeStrategy(newStrategy); // [5] 在使用默认的 Soft strategy 之后，我们逐步遍历数组中的所有 Strategy，并使用 changeStrategy() 方法将每个 Strategy 放入 变量 s 中。
			s.communicate(); // [6] 现在，每次调用 communicate() 都会产生不同的行为，具体取决于此刻正在使用的策略代码对象。我们传递的是行为，而非仅数据
		}
	}
}
