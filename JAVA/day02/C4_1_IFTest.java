package com.shinhan.day02;

public class C4_1_IFTest {

	public static void main(String[] args) {
		method7();
	}
	
	private static void method7() {
		// wrapper class => 기본형 + 기능추가
		char grade = 'A';
		String message;
		
		grade = Character.toLowerCase(grade); // 소문자로 변환
		
		switch (grade) {
		case 'a' -> {
			message = "우수 회원";
		}
		case 'b' -> {
			message = "일반 회원";
		}
		default -> {
			message = "손님";
		}
		}
		System.out.printf("%s 입니다.\n", message);
		
		if (grade == 'a') {
			message = "우수 회원";
		} else if (grade == 'b') {
			message = "일반 회원";
		} else {
			message = "손님";
		}
		System.out.printf("%s 입니다.\n", message);
	}

	private static void method6() {
		char grade = 'A';
		String message;

		if (grade == 'A' || grade == 'a') {
			message = "우수 회원";
		} else if (grade == 'B' || grade == 'b') {
			message = "일반 회원";
		} else {
			message = "손님";
		}
		System.out.printf("%s 입니다.\n", message);

		switch (grade) {
		case 'A', 'a': {
			int point = 100; // 여기서만 쓰고 싶은 변수가 있다면 {}로 싸면 사용가능
			message = "우수 회원" + point;
			break;
		}
		case 'B', 'b':
			String point = "good";
			message = "일반 회원" + "point";
			break;
		default:
			message = "손님";
		}
		System.out.printf("%s 입니다.\n", message);

		// 12버전부터 지원
		switch (grade) {
		case 'A', 'a' -> {
			message = "우수 회원"; // break가 자동
		}
		case 'B', 'b' -> {
			message = "일반 회원";
		}
		default -> {
			message = "손님";
		}
		}
		System.out.printf("%s 입니다.\n", message);
	}

	private static void method5() {
		// Math : 수학공식들을 유용하게 사용하기 위한 기능들이 들어있다.
		double su = Math.random(); // 0 <= x < 1

		int result = (int) (su * 10) + 1;
		System.out.println(result);

	}

	private static void method4() {
		int score = 80;
		String grade;

		// break는 switch 빠지기, break가 없으면 무조건 아래로 흐른다.
		// else if가 여러개 있다면 switch가 좀더 빠르다.
		switch (score / 10) {
		// 17버전은 ,가능 => 10,9
		// 8, 11, 버전은 불가
		case 10, 9:
			grade = "A";
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.printf("%s 학점\n", grade);
		System.out.println("========switch end========");
	}

	private static void method3() {
		int score = 80;
		String grade;

		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		System.out.printf("%s 학점\n", grade);
		System.out.println("=============");
	}

	private static void method2() {
		int score = 80;

		if (score >= 90) {
			System.out.println("A학점");
		} else if (score >= 80) {
			System.out.println("B학점");
		} else if (score >= 70) {
			System.out.println("C학점");
		} else if (score >= 60) {
			System.out.println("D학점");
		} else {
			System.out.println("F학점");
		}
		System.out.println("=============");
	}

	private static void method1() {
		int score = 80;

		if (score >= 90) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

		System.out.println("if 끝");
	}
}
