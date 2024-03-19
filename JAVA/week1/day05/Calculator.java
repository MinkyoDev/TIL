package com.shinhan.week1.day05;

public class Calculator {

	// 1. static field
	static double pi = 3.141592;
	static String company = "퍼스트존";
	static String company2;
	
	String color;

	// 2. static block
	static {
		System.out.println("class load시에 1회 수행");
		company2 = "상공회의소";
	}

	// static method
	static int plus(int a, int b) {
		Calculator cal = new Calculator();
		cal.color = "red";
		return a + b;
	}

	int minus(int a, int b) {
		return a - b;
	}
	
	double round(int a) {
		return a*2*pi;
	}

}
