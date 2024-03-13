package com.shinhan.day02;

// 자바 프로그램은 class들로 이루어짐
// 하나의 .java 파일에 여러개의 class가 가능
// public class이면 반드시 독립적인 파일로 저장한다.
public class Review {

	// 1. 멤버 변수
	// 2. 생성자
	// 3. 메서드
	// 4. block
	// 5. inner class

	public static void main(String[] args) {
		System.out.println("main 시작");
		f1();
		f2();
		System.out.println("main 끝");
	}

	private static void f2() {
		// method내에 있는 변수는 지역변수이다.
		// 변수 scope : {}내에서만 유효하다.
		
		{
			int score = 100;
		}
//		System.out.println(score); // error
		
		int v1 = 1;
		
		System.out.println("v1: " + v1);
		
		if (true) {
			int v2 = 2;
			
			if (true) {
				int v3 = 2;
				
				System.out.println("v1: " + v1);
				System.out.println("v2: " + v2);
				System.out.println("v3: " + v3);
			}
			System.out.println("v1: " + v1);
			System.out.println("v2: " + v2);
//			System.out.println("v3: " + v3); // error
		}
		System.out.println("v1: " + v1);
//		System.out.println("v2: " + v2); // error

	}

	// void는 return이 없음
	private static void f1() {
		System.out.println("f1 함수 시작");

		// 변수 : 하나의 값을 저장하기 위한 기억장소 이름
		// 1) 변수 선언 : 데이터 성격에 따라 기본형/참조형
		// 기본형(8가지) : byte(1), short(2), char(2), int(4), long(8), float(4), double(8),
		// boolean(1)
		// 기본형 : 값 저장, 연산, 비교만 가능, 기능은 없다.
		// Wrapper class => 기본형 + 기능 추가
		// Byte, Short, Character, Integer, Long, Float, Double, Boolean
		int var1; // var1 변수는 int를 저장하고자 한다.

		// 2) 변수 초기화
		var1 = Integer.MAX_VALUE; // =은 할당연산자
		System.out.println(var1);

		Integer var2 = 100;
		System.out.println(var2.toString());

		// 3) 변수 사용
		System.out.println("f1 함수 끝");
	}
}

class Review2 {

}