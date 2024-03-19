package com.shinhan.week1.day01;

public class 기본형변수타입 {

	public static void main(String[] args) {
		// 제어문자
		String str = "이것이 \n \"자바\" '자바' 다.";
		System.out.println(str);

		String str2 = "aaaaaaaaaaaaa " + "bbbbbbbbbbbb " + "ccccccccccccc";
		System.out.println(str2);

		// JAVA 17 이상부터 지원
		String str3 = """
				json 타입의 값을 저장할 때 유용하다.
				{
					"key": "value"
				}
				""";
		System.out.println(str3);

	}

	public static void f10(String[] args) {
		// 데이터 타입(데이터의 성격)
		// 1. 기본형(8가지) : 값을 저장, 연산, 비교
		// 2. 객체 참조형 : 기능을 가진다.
		// 3. Wrapper class : 기본형(8가지) + 기능
		// byte + 기능 => Byte
		// short + 기능 => Short
		// char + 기능 => Character
		// int + 기능 => Integer
		// long + 기능 => Long
		// float + 기능 => Float
		// double + 기능 => Double
		// boolean + 기능 => Boolean

		Integer score = 65;
		System.out.println(Integer.toBinaryString(score));

		double d = score.doubleValue();
		System.out.println("double로 바꿈 : " + d);
	}

	public static void f9(String[] args) {
		// 문자열을 저장
		// 1. 객체 참조 변수 선언
		String str1, str2, str3, str4;

		// 2. 객체 생성
		str1 = new String("자바 언어의 문법 배우기.");

		// 위가 근본이지만 아래도 가능
		str1 = "자바 언어의 문법 배우기."; // 컴파일 타임에 저장된다.
		str2 = "자바 언어의 문법 배우기."; // 이미 저장된 값을 사용한다.
		str3 = new String("자바 언어의 문법 배우기."); // 새로운 값이 생성됨
		str4 = new String("자바 언어의 문법 배우기."); // 실행시 생성

		// 기본형은 값이 직접 저장
		// 객체 참조형은 주소가 저장

		System.out.println(str1);
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		System.out.println(str1 == str2);
		System.out.println(str3 == str4); // ==은 주소를 비교함. 주소가 다르다.
		System.out.println(str1.equals(str4)); // 내용을 비교
	}

	public static void f8(String[] args) {
		boolean var1 = true;
		boolean var2 = false;
		boolean var3 = 20 > 10;

		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
	}

	public static void f7(String[] args) {
		double var1 = 3.14;

		System.out.println(var1);
	}

	public static void f6(String[] args) {
		// 실수의 기본값은 double
		float var1 = 3.14f; // f는 대소문자 상관 없음

		System.out.println(var1);
	}

	public static void f5(String[] args) {
		// 정수의 기본은 int
		// 선언 + 할당
		long var1 = 2147483648L; // 끝에다가 대소문자 상관없이 L을 넣음. 소문자는 1과 구별이 어려워 잘 안씀

		// 사용
		System.out.println(var1);
	}

	public static void f4(String[] args) {
		// 선언 + 할당
		int var1 = Integer.MAX_VALUE;
		int var2 = 2147483647;

		var2++;
		// 사용
		System.out.println(var1);
		System.out.println(var2);
	}

	public static void f3(String[] args) {
		// 선언 + 할당
		char a = 'A'; // char는 한 문자만 그리고 ''
		char b = 65;
		char c = 0x0041;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}

	public static void f2(String[] args) {
		// 1. 변수 선언
		short a; // -32768 ~ 32767

		// 2. 초기화
		a = 32767;

		a++; // -32768으로 바뀜

		// 3. 사용
		System.out.println("short 타입 값" + a);
	}

	public static void f1(String[] args) {
		// 변수 : 하나의 값을 저장하기 위한 기억장소 이름
		// 선언 후 사용한다.

		// 1. 선언
		byte a; // a 변수는 byte 값을 담을 수 있다.

		// 2.할당(초기화)
		a = 127;

		a++; // a = a + 1

		// 지역변수 (메서드 내의 변수)는 반드시 초기화하고 사용한다.
		System.out.println(a);
	}
}
