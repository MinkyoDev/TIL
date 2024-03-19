package com.shinhan.week1.day05;

public class C6_7_CalculatorTest {

	public static void main(String[] args) {
		System.out.println(Calculator.company);
		System.out.println(Calculator.company2);
		System.out.println(Calculator.plus(1, 2));
		
		new Calculator().minus(1, 2);
		
		Calculator cal = new Calculator();
		cal.minus(1, 2);
	}
}
