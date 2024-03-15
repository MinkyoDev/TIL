package com.shinhan.day04;

public class C6_3_KoreanTest {

	public static void main(String[] args) {
		method1();
	}
	
	private static void method1() {
		// 1. 객체 참조 변수 선언
		// 2. 객체 생성
		Korean k1 = new Korean("신현상", "12345");
		Korean k2 = new Korean("신현상");
		
		// 3. 객체 사용
//		System.out.println(k1.nation);
//		System.out.println(k1.name);
//		System.out.println(k1.ssn);
		
		k1.print();
		k2.print();
	}
}
