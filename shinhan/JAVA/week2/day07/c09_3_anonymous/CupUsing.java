package com.shinhan.day07.c09_3_anonymous;

public class CupUsing {

	public static void main(String[] args) {
		print(new CoffeeCup());
		print(new WaterCup());

		print(new Cup() {

			@Override
			public void use() {
				System.out.println("익명 구현 class");
			}
		});

		print(() -> System.out.println("lamda"));
	}

	private static void print(Cup cup) {
		cup.use();
	}
}
