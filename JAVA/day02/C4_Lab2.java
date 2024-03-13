package com.shinhan.day02;

import java.util.Scanner;

public class C4_Lab2 {

	public static void main(String[] args) {
//		prob7(12);
		prob8(15, 5);
	}

	private static void prob1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int input = sc.nextInt();

		if (input < 2 || 9 < input) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return;
		}

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", input, i, input * i);
		}

		sc.close();
	}

	private static void prob2() {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;

		System.out.print("2 ~ 100사이의 정수를 입력하세요. :  ");
		int input = sc.nextInt();

		if (input < 2 || 100 < input) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return;
		}

		for (int i = 1; i < input; i++) {
			if (input % i == 0) {
				cnt += 1;
			}
		}

		if (cnt == 1) {
			System.out.printf("%d는(은) 소수입니다.", input);
		} else {
			System.out.printf("%d는(은) 소수가 아닙니다", input);
		}

		sc.close();
	}

	private static void prob3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int input = sc.nextInt();

		if (input < 2 || 9 < input) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return;
		}

		for (int i = 1; i <= input; i++) {
			int fac = 1;
			for (int j = 1; j <= i; j++) {
				fac *= j;
			}
			System.out.printf("%d ! = %d\n", i, fac);
		}

		sc.close();
	}

	private static void prob4() {
		Scanner sc = new Scanner(System.in);

		System.out.print("양의 정수를 입력하세요 : ");
		int input = sc.nextInt();

		int multi = 1000 / input;
		int total = 0;
		for (int i = 1; i <= multi; i++) {
			total += input * i;
		}

		System.out.println("7의 배수 개수 = " + multi);
		System.out.println("7의 배수 합 = " + total);

		sc.close();
	}

	private static void prob5() {
		int num = 1;
		int diff = 1;
		int total = 1;

		for (int i = 1; i <= 14; i++) {
			num += diff;
			diff += 1;
			total += num;
		}

		System.out.println("15번째까지의 합 : " + total);

	}

	private static void prob6() {
		int year = 2012;
		boolean isLeap = false;

		if (year % 400 == 0) {
			isLeap = true;
		} else if (year % 100 == 0) {
			isLeap = false;
		} else if (year % 4 == 0) {
			isLeap = true;
		}

		if (isLeap) {
			System.out.println("2010년 2월의 말일은 29일 입니다.");
		} else {
			System.out.println("2010년 2월의 말일은 28일 입니다.");
		}

	}

	private static void prob7(int month) {
		int days = 0;

		if (month < 1 || 12 < month) {
			System.out.println(month + "월은 존재하지 않습니다. 다시 입력하세요.");
			return;
		}

		switch (month) {
		case 4, 6, 9, 11:
			days = 30;
			break;
		case 1, 3, 5, 7, 8, 10, 12:
			days = 31;
			break;
		case 2:
			days = 28;
			break;
		}

		System.out.println(days);

	}

	private static void prob8(int num1, int num2) {
		
		for (int i=num1;i>0;i--) {
			if (num1 % i == 0 && num2 % i == 0) {
				System.out.println(i);
				break;
			}
		}
	} return i
}
