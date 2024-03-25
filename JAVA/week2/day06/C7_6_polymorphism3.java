package com.shinhan.day06;

class A {
	int score = 100;
	void print() {}
}

class B extends A {
	int score2 = 99;
	void print2() {}
}
class C extends A {}
class D extends B {}
class E extends C {}

public class C7_6_polymorphism3 {

	public static void main(String[] args) {
		method2();
	}

	private static void method2() {
		// A type이므로 변수의 타입을 따른다.
		A var1 = new B();
		System.out.println(var1.score);
//		System.out.println(var1.score2);  // 불가

		var1.print();
//		var1.print2();  // 불가

		// 형변환 하면 호출 가능
		B var2 = (B) var1;
		System.out.println(var2.score2);
		var2.print2();
		;

		// var1은 B로 만들었으므로 C로는 형변환 불가
//		C var3 = (C) var1;
//		System.out.println(var3.score2);
//		var3.print2();

		if (var1 instanceof B var3) {
			System.out.println(var3.score2);
			var3.print2();

		}
	}

	private static void method1() {
		Object obj = new A();
		A a = new A();

		Object b1 = new B();
		A b2 = new B();
		B b3 = new B();

		Object c1 = new C();
		A c2 = new C();
		C c3 = new C();

		Object d1 = new D();
		A d2 = new D();
		B d3 = new D();
		D d4 = new D();

	}
}
