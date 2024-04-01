package com.shinhan.day06.lab4;

class A {}

class B extends A {}

class C extends A {}

class D extends B {}

class E extends B {}

public class Prob09 {

	public static void main(String[] args) {
		B b1 = new B();
//		B b2 = (B) new A();  // 답: (B) new A()
		B b3 = new D();
		B b4 = new E();
		
		method(b1);
//		method(b2);
		method(b3);
		method(b4);
		
	}
	static void method (B b) {}
}
