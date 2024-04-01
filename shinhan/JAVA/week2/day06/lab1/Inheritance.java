package com.shinhan.day06.lab1;

class C extends B {
	int meth() {
		return 100;
	}

	int sMeth() {
		return 100;
	}
}

class B extends A {
	int meth() {
		return 10;
	}

	int sMeth() {
		return 10;
	}
}

class A {
	int meth() {
		return 1;
	}

	int sMeth() {
		return 1;
	}
}

public class Inheritance {
	public static void main(String[] args) {
		C c = new C();
//		B b = (B) c;
//		A a = (A) c;
		B b = c;
		A a = c;

		if (a instanceof A) {
			System.out.println("a는 A의 인스턴스 이다.");
		}
		if (a instanceof B) {
			System.out.println("a는 B의 인스턴스 이다.");
		}
		if (a instanceof C) {
			System.out.println("a는 C의 인스턴스 이다.");
		}

		System.out.println(
				a.meth() + " " + b.meth() + " " + c.meth() + " " + a.sMeth() + " " + b.sMeth() + " " + c.sMeth());
	}
}
