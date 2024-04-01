package com.shinhan.day07.c09_3_anonymous;

public class LamdaTest {

	public static void main(String[] args) {

		int result = (new Calculator() {

			@Override
			public int sum(int a, int b) {
				System.out.println("익명 구현 class");
				return a + b + 100;
			}
		}).sum(1, 2);
		System.out.println(result);

		Calculator cal = (x, y) -> {
			System.out.println("lamda");
			return x + y + 200;
		};
		result = cal.sum(10, 20);
		System.out.println(result);
	}
}
