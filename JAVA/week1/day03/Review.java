package com.shinhan.week1.day03;

public class Review {

	public static void main(String[] args) {
		call2(100);
		call2(55);
		call3(10);
	}

	// 반복 사용을 위해 메서드를 만든다.
	private static void call5(int a) {
		// 반복문 do while
		int total = 0;
		int i = 1;

		do {
			if (i == 1) break;
			total += i;
			i++;
		} while (i <= a);
		System.out.println("do while 합계 : " + total);
	}

	private static void call4(int a) {
		// 반복문 while
		int total = 0;
		int i = 1;

		while (i <= a) {
			total += i;
			i++;
		}
		System.out.println("while 합계 : " + total);
	}

	private static void call3(int a) {
		// 반복문 for : 1 ~ a까지 합계구하기
		int total = 0;

		for (int i = 1; i <= a; i++) {
			total += i;
		}

		System.out.println("합계 : " + total);
	}

	private static void call2(int a) {
		// 조건문 switch - switch문의 조건은 정수, 문자열만 가능, 실수는 불가능
		switch (a % 2) {
		case 0:
			System.out.println(a + " 짝수");
			break;
		case 1:
			System.out.println(a + " 홀수");
		}
	}

	private static void call(int a) {
		// 조건문 if
		if (a % 2 == 0) {
			System.out.println(a + " 짝수");
		} else {
			System.out.println(a + " 홀수");
		}

		// 삼항연산자
		System.out.println(a % 2 == 0 ? a + "짝수" : a + " 홀수");

	}
}
