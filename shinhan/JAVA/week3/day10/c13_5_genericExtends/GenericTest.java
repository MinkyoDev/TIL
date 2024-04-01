package com.shinhan.day10.c13_5_genericExtends;

import com.shinhan.day10.c13_1_generic.Product;

public class GenericTest {

	public static void main(String[] args) {
		Product<Double, Integer> p1 = makeProduct(3.14, 200);
		System.out.println((p1));

		boolean result = compare(10, 20);
//		boolean result2 = compare(10, "");
		System.out.println(result);
	}

	private static <T extends Number> boolean compare(T i, T j) {
		double d1 = i.doubleValue();
		double d2 = j.doubleValue();
//		return i == j;  // 주소비교
		return d1 == d2;
	}

	private static <A extends Number, B> Product<A, B> makeProduct(A a, B b) {
		Product<A, B> p = new Product<A, B>(a, b);
		return p;
	}
}
