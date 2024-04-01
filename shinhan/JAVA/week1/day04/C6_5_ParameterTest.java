package com.shinhan.week1.day04;

public class C6_5_ParameterTest {

	public static void main(String[] args) {
		C6_5_ParameterTest aa = new C6_5_ParameterTest();
		aa.sum(10, 20);

		sum2(10, 20);
		sum2(10, 20, 40);
		sum(10, 20, 40, 4, 2);

		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		sum(values);

		sum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });

		sum("자바", "프로그램");

		sum
		(3.14, 2.7, 6.745);
	}

	static void sum(double d, double e, double f) {
		System.out.println("실수: " + d + e + f);
	}

	static void sum(String s1, String s2) {
		System.out.println("문자2: " + s1 + s2);
	}

	// method Overloading : 메서드 이름은 같고 메개변수 사양은 다르다.
	static void sum(int... datas) {
		int total = 0;
		for (int data : datas) {
			total += data;
		}
		System.out.println("가변길이 매게변수: " + total);
	}

	static void sum2(int i, int j, int k) {
		System.out.println("정수 합: " + (i + j + k));
	}

	// static은 static에서만 호출 가능
	static void sum2(int i, int j) {
		System.out.println("정수 합: " + (i + j));
	}

	// 멤버 메서드(non-static) : 객체 생성 후 호출이 가능
	void sum(int i, int j) {
		System.out.println("정수 합: " + (i + j));
	}

}
