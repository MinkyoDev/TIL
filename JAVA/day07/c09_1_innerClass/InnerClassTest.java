package com.shinhan.day07.c09_1_innerClass;

// 외부 class
class OuterClass {

	// instance 변수
	int a = 100;
	int score = 99;

	// class 변수
	static int b = 200;

	// instance method
	void method1() {
	}

	// static method
	static void method2() {
	}

	// instance inner class
	class InnerClass {

		// instance 변수
		int a2 = 100;
		String score = "A";

		// class 변수
		static int b2 = 200;

		// instance method
		void method3() {
			System.out.println("inner class의 method3: " + (a + b + a2 + b2));
			System.out.println("inner class의 field: " + score);
			System.out.println("outer class의 field: " + OuterClass.this.score);
		}

		// static method
		static void method4() {
			System.out.println("inner class의 method4: " + (b + b2));
		}
	}

	static class InnerClass2 {

		// instance 변수
		int a2 = 100;
		String score = "A";

		// class 변수
		static int b2 = 200;

		// instance method
		void method3() {
			System.out.println("inner class의 method3: " + (b + a2 + b2));
			System.out.println("inner class의 field: " + score);
//			System.out.println("outer class의 field: " + OuterClass.this.score);  // 사용불가
		}

		// static method
		static void method4() {
			System.out.println("inner class의 method4: " + (b + b2));
		}
	}

	void call() {
		
		// 지역변수 : 내부 class에서 접근하면 변경불가 final
		int price = 1000;
		
		// method 내에 있는 class. method 내에서만 접근 가능
		class LocalClass {
			
			// field
			int price2 = 2000;
			static int price3 = 3000;
			
			// method
			void show() {
				System.out.println("LocalClass instance method");
//				System.out.println("price: "+price);
			}
			
			static void show2() {
				System.out.println("LocalClass static method");
			}
		}
		
		System.out.println(price);
		
		// static
		System.out.println(LocalClass.price3);
		LocalClass.show2();
		
		// instance
		LocalClass local = new LocalClass();
		System.out.println(local.price2);
		local.show();
		
	}
}

public class InnerClassTest {

	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		System.out.println(OuterClass.InnerClass2.b2);
		OuterClass.InnerClass2.method4();

		OuterClass.InnerClass2 inner = new OuterClass.InnerClass2();
		System.out.println(inner.a2);
		System.out.println(inner.score);
	}

	public static void f1() {

		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();

		// instance
		System.out.println(inner.a2);
		System.out.println(inner.score);
		inner.method3();

		// static
		System.out.println(OuterClass.InnerClass.b2);
		OuterClass.InnerClass.method4();
	}
}
