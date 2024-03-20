package com.shinhan.day07.c16_1_lambda;

public class LambdaTest2 {

	public static void main(String[] args) {
		Person person = new Person(10, 20);
		person.action(new ComputeInterface() {

			@Override
			public double calc(double x, double y) {
				System.out.println("======익명 구현 class(-)======");
				return x - y;
			}
		});
		person.action((a, b) -> {
			System.out.println("======lambda(+)======");
			return a + b;
		});
		
		// 만들어진 static method 사용
		person.action(Computer::staticMethod);
		
		// 만들어진 instance method 사용
		Computer com = new Computer();
		person.action(com::instanceMethod);
	}
}
