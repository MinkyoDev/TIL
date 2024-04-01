package com.shinhan.day06.copy;

// Object는 최상위 class
class Parent2 extends Object {
	int score = 100;

	void show() {
		System.out.println("부모에서 score 접근: " + score);
	}
}

class Child2 extends Parent2 {
	String score = "A";
	
	// Override(덮어쓰기) : 이름, 매개변수, return, modifier 같다.
	@Override
	void show() {
		System.out.println("자식에서 score 접근: " + score);
	}
	
	// Overloading(추가) : 이름은 같고 매개변수 사양이 다르다.
	void show(String a) {
		System.out.println("===========");
		show();  // 자신의 class에 재정의 되어 있는 메서드 수행
		super.show();  // super는 부모를 의미
		System.out.println("자식에서 score 접근: " + score);
	}

	void print() {
		System.out.println("자식이 score 접근: " + score);
		show();
	}
}

public class C7_2_InheritenceTest2 {

	public static void main(String[] args) {
		Child2 aa = new Child2(); // Object 생성, parent2 생성, Child2 생성
		System.out.println(aa.score);
		aa.print();
		aa.show();
		aa.show("aa");
	}
}
