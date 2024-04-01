package com.shinhan.day12.c16_1_lambda;

@FunctionalInterface
interface Calculable {

	double calc(double x, double y);
}

class MyCalculator implements Calculable {

	@Override
	public double calc(double x, double y) {
		return x + y;
	}
}

class Computer {
	public static double staticMethod(double x, double y) {
		return x + y + 100;
	}

	public double instanceMethod(double x, double y) {
		return x + y + 200;
	}
}

public class LambdaTest2 {

	public static void main(String[] args) {
		System.out.println("1. 구현 class 이용");
		MyCalculator a = new MyCalculator();
		System.out.println("result = " + a.calc(1, 2));

		System.out.println("2. 익명구현 class 이용");
		Calculable b = new Calculable() {

			@Override
			public double calc(double x, double y) {
				return x - y;
			}
		};
		System.out.println("result = " + b.calc(1, 2));

		System.out.println("3. lambda 이용");
		Calculable c = (double x, double y) -> x * y;
		System.out.println("result = " + c.calc(1, 2));

		Calculable c1 = (x, y) -> {
			return x * y;
		};
		System.out.println("result = " + c1.calc(1, 2));

		Calculable c2 = Computer::staticMethod;
		System.out.println("result = " + c2.calc(1, 2));

		Computer computer = new Computer();
		Calculable c3 = computer::instanceMethod;
		System.out.println("result = " + c3.calc(1, 2));

	}
}
