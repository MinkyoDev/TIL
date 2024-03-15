package com.shinhan.day04;

// class : object를 만들기 위한 틀 (template), 설계도
// object는 class를 이용해서 만든 독립된 실체(instance)
public class Book {

	// 1. field (변수, data 저장이 목적, 특징)
	String title;
	int price;

	// 2. constructor(생성자, 생성자메서드) : argment가 없는 기본 생성자는 컴파일시에 만들어진다.
	// 생성자 추가 가능, return 불가, class 이름과 반드시 같아야 한다.
	// Overloading (이름은 같고 매개변수 사양이 다르다.)
	Book() {
//		System.out.println("default 생성자를 재정의함.");
		// 같은 이름의 다른 모양의 생성자를 호출하기 : this()
		this(null, 0);
	}

	Book(String title, int price) {
//		System.out.println("argument 2개 생성자");
		// this : 현재 객체
		this.title = title;
		this.price = price;
	}

	Book(String title) {
//		System.out.println("argument 1개 생성자");
//		// this : 현재 객체  -  매개변수 이름과 field 이름이 충돌시 구분하기 위해 사용
//		this.title = title;
//		this.price = 50000;
		this(null, 0);
	}

	Book(int price) {
//		System.out.println("argument 1개 생성자");
//		// this : 현재 객체
//		this.title = "Unknown";
//		this.price = price;
		this("Unknown", price);
	}

	// 3. method (함수, 기능) : 반드시 return type을 정의한다.
	// return값이 없다면 void
	void bookInfoPrint(){
		System.out.println("======책의 정보======");
		System.out.println("제목: " + title);
		System.out.println("가격: " + price);
	}
	// 4. block
	{
		System.out.println("block...object 생성시 수행");  // 활용도는 별로 없음...
	}
	static {
		System.out.println("class load시 1회 수행");		
	}
	
	// 5. inner class
	class AA {
		
	}
}
