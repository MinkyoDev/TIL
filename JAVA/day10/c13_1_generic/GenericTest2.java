package com.shinhan.day10.c13_1_generic;

public class GenericTest2 {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		Product<String, Integer> p1 = new Product<>();
		p1.setKind("ABC");
		p1.setModel(200);

		Product<String, Integer> p2 = new Product<>("Computer", 100);

		System.out.println(p1);
		System.out.println(p2);

	}
}
