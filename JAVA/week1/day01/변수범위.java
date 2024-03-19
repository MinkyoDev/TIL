package com.shinhan.week1.day01;

// 1. 하나의 java 파일에 여러개의 class가 올 수 있다.

public class 변수범위 {
	// 1. 멤버 변수 : 자동 초기화된다.
	// static 메서드에서 non-static 변수를 사용불가 (메모리에 올라오지 않음)
//	String model;
	static String model;
	static int price; // static을 붙이면 사용 가능. 기본형이 아니면 무조건 null값 들어감. 정수는 0

	public static void main(String[] args) {
		f1();
		f2();
	}

	private static void f2() {
		// 1. 변수 선언
		int a; // a는 int를 담을 수 있다.
		Car c1, c2; // c1은 Car를 담을 수 있다.
		
		// 2. 객체 생성, 값 할당
		a = 100; // 기본형은 100을 a에 저장한다.
		c1 = new Car(); // Car를 만든다.
		c2 = new Car();
		c2.model = "abc";
		c2.price = 2000;
		
		// 3. 객체 사용
		System.out.println(a);
		System.out.println(c1.model);
		System.out.println(c1.price);
		System.out.println(c2.model);
		System.out.println(c2.price);
		
		c1.drive();
		c2.drive();
		
	}

	private static void f1() {
		// 함수내의 변수는 지역변수이다.(stack에 저장됨) 반드시 초기화 후 사용한다.
		int a = 100;
		System.out.println("a = " + a);

		System.out.println("멤버 변수 접근 model = " + model);
		System.out.println("멤버 변수 접근 price = " + price);

	}
}

// class : 변수(data 저장) + 메서드(기능)
// class : object를 만들기 위한 template (틀)
class Car {
	String model;
	int price;

	void drive() {
		System.out.println(model + ":" + price);
	}
}