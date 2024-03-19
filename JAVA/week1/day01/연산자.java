package com.shinhan.week1.day01;

/*
 * >javac 연산자.java => 연산자.class 생성
 * >java 연산자 
 * 1. 연산자.class가 메모리에 올라온다.
 * 2. 검증
 * 3. main 시작
 * 4. main 끝
 */

public class 연산자 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

	private static void f4() {
		int java = 100;
		int sql = 99;
		int web = 97;
		int count = 3;
		int total = java + sql + web;
		double avg = total / 3.0; // 3으로 나누면 int/int = int로 나와서 소수부분이 사라진다.
		double avg2 = (double)total / count; // (double)total이나 (double)count나 똑같은 결과가 나옴
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		System.out.println("평균 : " + avg2);
		
	}

	private static void f3() {
		int a = 10;
		double b = 20.5f;
		double c = a + b; // 자동 형변환 int a => double a
		int d = (int) (a + b);
		
		System.out.println(d);
	}

	private static void f2() {
		float a = 10.5f;
		float b = 20.5f;
		float c = a + b;

		double d = 30.5;
		double e = a + d; // 자동 형변환
		float f = (float) (a + b); // 강제 형변환

	}

	private static void f1() {
		byte a = 10;
		byte b = 20;
//		byte c = a + b; // 피연산자를 무조건 int로 변환
		byte c = (byte) (a + b);
		int d = a + b;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
	}
}

// public은 하나만 가능
//public class FirstZone {
//	
//}