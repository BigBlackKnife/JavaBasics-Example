package com.functional;

/**
 * @author Blaife
 * @description Runnable接口的引用
 * @date 2020/8/4 23:25
 */
class Go {
	static void go() {
		System.out.println("Go::go()");
	}
}

public class RunnableMethodReference {
	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymous");
			}
		}).start();

		new Thread(() -> System.out.println("lambda")).start();
		
		// 相当于是 Runnable runnable = Go::go;
		new Thread(Go::go).start();
		
	}
}
