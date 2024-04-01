package com.shinhan.week1.day01;

// JVM이 String 변환 클래스의 main()메서드 호출을 위해 접근권한이 public이다.

public class String변환 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

	private static void f4() {
		int a = 100;
		{
			// 무조건 실행
			int b = 200;
			System.out.println("1 : " + (a + b));
		}
		if (a >= 100) {
			// 조건이 맞다면 실행
			int b = 300;
			System.out.println("2 : " + (a + b));
		}
//		System.out.println("3 : " + (a+b)); // b는 중괄호 안에서만 사용가능
//		System.out.println(b); // b는 중괄호 안에서만 사용가능

	}

	private static void f3() {
		int a = 100;
		String s = String.valueOf(a);
		System.out.println(s);

		String s2 = a + ""; // +를 사용하면 메모리 낭비가 생겨서 좋은 방법은 아니다.
		System.out.println(s2);

	}

	public static void f2() {
		String score = "100";

		// strind에서 +는 연결을 의미함
		System.out.println(score + 200); // string
		System.out.println(1 + 2 + score); // 3 + 100 = 3100
		System.out.println(8 - 2 + score); // 6 + 100 = 6100
	}

	public static void f1() {
		String score = "100";

		byte a = Byte.parseByte(score); // 1
		short b = Short.parseShort(score); // 2
		int c = Integer.parseInt(score); // 4
		long d = Long.parseLong(score); // 8
		float e = Float.parseFloat(score); // 4
		double f = Double.parseDouble(score); // 8

		System.out.println(a + b + c + d + e + f);
	}

}
