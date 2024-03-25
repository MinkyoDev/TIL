package com.shinhan.day08.c12_1_javaBaseModule;

public class OjectTest {

	public static void main(String[] args) {
		f6();
	}

	private static void f6() {
		// HashSet : 순서가 없고 중복이 안된다. Key로 사용된다.
	}

	private static void f5() {
		// Object를 상속받아서 만든 Dice
		Book obj1 = new Book("자바", 100, "신용권");
		Book obj2 = new Book("자바", 100, "신용권");

		System.out.println(obj1 == obj2); // 주소 비교
		System.out.println(obj1.equals(obj2)); // 주소 비교를 내용 비교로 override
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f4() {
		// Object를 상속받아서 만든 Dice
		Dice obj1 = new Dice(100);
		Dice obj2 = new Dice(100);

		System.out.println(obj1 == obj2); // 주소 비교
		System.out.println(obj1.equals(obj2)); // 주소 비교를 내용 비교로 override
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f3() {
		// Object를 상속받아서 만든 Integer
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer(100);

		System.out.println(obj1 == obj2); // 주소 비교
		System.out.println(obj1.equals(obj2)); // 주소 비교를 내용 비교로 override
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f2() {
		// Object를 상속받아서 만든 String
		String obj1 = new String("자바");
		String obj2 = new String("자바");

		System.out.println(obj1 == obj2); // 주소 비교
		System.out.println(obj1.equals(obj2)); // 주소 비교를 내용 비교로 override
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f1() {
		// Object는 모든 Object의 부모 class
		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.println(obj1 == obj2); // 주소 비교
		System.out.println(obj1.equals(obj2)); // 주소 비교
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}
}
