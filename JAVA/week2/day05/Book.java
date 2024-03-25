package com.shinhan.week1.day05;

public class Book {

	// 1. field
	// class 변수
	static int bookCount;

	// instance 변수
	String title;
	int price;

	// final : 수정 불가
	// - 선언시 초기화 or 생성자로 초기화 or instance block으로 초기화
	final String publish = "한빛미디어";
	final String publish2;
	final String publish3;

	// 상수(불변), 대문자로 선언
	// - 선언시 초기화 or static block을 통해서 초기화
	final static String ISBN = "1234-5678";
	static final String ISBN2;  // 순선는 상관 x

	// 2. constructor
	Book() {
		System.out.println("default constructor");
		this.publish2 = "default 생성자로 초기화";
	}

	Book(String publish) {
		this.publish2 = publish;
	}

	// 3. method
	void setPublish() {
//		publish = "한빛미디어2"; // 변경불가
//		publish2 = "한빛미디어2"; // 변경불가
//		publish3 = "한빛미디어2"; // 변경불가
	}

	// 4. block
	{
		publish3 = "한빛미디어";
	}
	
	static {
		ISBN2 = "3333-4444";
	}
	// 5. inner class
}
