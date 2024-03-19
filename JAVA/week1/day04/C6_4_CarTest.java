package com.shinhan.week1.day04;

public class C6_4_CarTest {

	public static void main(String[] args) {
		method1();
		method2();
	}

	private static void method2() {
		Car c1 = new Car("abc model", "black", 300);
		System.out.println(c1);
	}

	private static void method1() {
		Car c1 = new Car("abc model", "black", 300);
		String result = c1.carInfoPrint("***");
		System.out.println(result);

		c1.powerOn();
	}
}
