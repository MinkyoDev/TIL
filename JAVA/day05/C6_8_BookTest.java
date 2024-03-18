package com.shinhan.day05;

// 다른 패키지에 있는 class를 이용하는 경우 반드시 import하고 사용
// java.lang 아래의 class는 import 없이 사용 가능

public class C6_8_BookTest {

	public static void main(String[] args) {
		method3();
	}

	private static void method3() {
		System.out.println(Integer.BYTES);
		System.out.println(Integer.compare(10, 30)); // 크면 1, 작으면 -1, 같으면 0
		
		int a = 10;
		int b = 20;
		System.out.println(Integer.max(a, b));
		System.out.println(a>b?a:b);
	}

	private static void method2() {
		// TODO Auto-generated method stub
//		Book.ISBN = "11111"; // 상수는 변경 불가
		
		System.out.println(Book.ISBN);
		System.out.println(Book.ISBN2);
		
		Book b1 = new Book();
		// 올바른 사용은 아니다.
		System.out.println(b1.ISBN);
		System.out.println(b1.ISBN2);
	}

	private static void method1() {
		System.out.println(Book.bookCount);

		Book b1 = new Book();
		System.out.println(b1.title);
		System.out.println(b1.price);
		System.out.println(b1.publish);
		System.out.println(b1.publish2);
		System.out.println(b1.publish3);
	}
}
