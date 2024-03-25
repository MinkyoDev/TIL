package com.shinhan.day10.c13_4_genericMethod;

import com.shinhan.day10.c13_1_generic.Product;

public class GenericTest {

	public static void main(String[] args) {
		Product<String, Integer> p1 = makeProduct("A", 100);
		Product<Integer, String> p2 = makeProduct(200, "B");
		Product<String, String> p3 = makeProduct("C", "D");

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

	private static <A, B> Product<A, B> makeProduct(A a, B b) {
		Product<A, B> p = new Product<>(a, b);
		return p;
	}

	public static void f2() {
		Box<String> result1 = makeBox("구체적 타입 사용시 결정");
		Box<Integer> result2 = makeBox(100);
		Box<Car> result3 = makeBox(new Car());

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}

	private static <T> Box<T> makeBox(T string) {
		Box<T> box = new Box<>(string);
		return box;
	}

	public static void f1() {
		Box<String> box1 = boxing("문자");
		Box<Integer> box2 = boxing(100);
		Box<Box<Integer>> box3 = boxing(new Box<>());

		Box<Product<String, Integer>> result1 = boxing(new Product<>("A", 100));
		Box<ChildProduct<String, Integer, String>> result2 = boxing(new ChildProduct<>("A", 12, "BB"));

		System.out.println(box1);
		System.out.println(box2.getContent());
		System.out.println(box3.getContent());
		System.out.println(result1.getContent());
		System.out.println(result2.getContent());
	}

	// 어떤게 들어와도 받을 수 있다.
	// <P> : generic 구체적인 타입이 아님
	// Box<P> : return type, generic type인 Box를 return
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.setContent(t);
		return box;
	}
}
