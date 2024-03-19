package com.shinhan.day06;

// class는 기본적으로 object를 상속
class Parent extends Object {
	String title = "부모에서 정의";
	private String title2 = "부모에서 정의";

	Parent() {
//		super();  // 자동으로 부모의 default 생성자를 호출
		System.out.println("부모의 default 생성자");
	}

	void show() {
		System.out.println("부모에서 정의한 show 메서드 - title: "+title);
		print();
	}

	private void print() {
		System.out.println("부모에서 정의한 print 메서드");
	}
}

class Child extends Parent {
	int title = 200;
	int score = 100;

	Child() {
//		super();  // 자동으로 부모의 default 생성자를 호출
		System.out.println("자식의 default 생성자");
	}

	void show2() {
		System.out.println("자식에서 정의한 show2 메서드");
		System.out.println("Parent title: " + title);
//		System.out.println("title: "+ title2);  // 부모의 private 접근 불가
//		print();  // 접근 불가
		show(); // 접근 가능
	}
}

public class C7_1_InheritenceTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		Child ch1 = new Child();
		System.out.println("InheritenceTest title: " + ch1.title);
		System.out.println(ch1.score);

		ch1.show();
		ch1.show2();

	}
}
