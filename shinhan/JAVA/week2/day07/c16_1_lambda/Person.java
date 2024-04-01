package com.shinhan.day07.c16_1_lambda;

public class Person {

	double num1, num2;

	public Person(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	// 로직은 사용하는 쪽에서 결정
	public void action(ComputeInterface compute) {
		double result = compute.calc(num1, num2);
		System.out.println(result);
	}
}
