package com.shinhan.day09.c12_4_otherClasses;

public class MathTest {

	public static void main(String[] args) {
		f1();
	}
	
	private static void f1() {
		double a = 5.1;
		
		System.out.println(Math.ceil(a));  // 올림
		System.out.println(Math.floor(a));  // 버림
		System.out.println(Math.round(a));  // 반올림
	}
}
