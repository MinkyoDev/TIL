package com.shinhan.day02;

import java.util.Scanner;

public class C4_Lab1 {

	public static void main(String[] args) {
//		problem1();
//		problem2();
//		problem3();
//		problem4('*', 3, true);
//		problem4('*', 5, false);
		problem5();
	}

	private static void problem1() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		System.out.print("초기값을 정수로 입력하세요. : ");
		int first = sc.nextInt();
		System.out.print("마지막 값을 정수로 입력하세요. : ");
		int last = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요. : ");
		int increment = sc.nextInt();

		for (int i = first; i <= last; i += increment) {
			sum += i;
		}

		if (sum > 1000)
			sum += 2000;
		System.out.printf("총합은 %d 입니다.", sum);
	}

	private static void problem2() {
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열을 입력하세요. : ");
		String str = sc.nextLine().toUpperCase();

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.substring(0, i));
		}
	}

	private static void problem3() {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		int start;

		System.out.print("숫자를 입력하세요. : ");
		int num = sc.nextInt();

		if (num % 2 == 1) {
			start = 1;
		} else {
			start = 0;
		}

		for (int i = start; i <= num; i += 2) {
			total += i;
		}

		System.out.printf("결과 값 : %d\n", total);
	}

	private static void problem4(char cell, int size, boolean isRect) {

		if (isRect) {
			for (int row = 1; row <= size; row++) {
				for (int col = 1; col <= size; col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		} else {
			for (int row = 1; row <= size; row++) {
				for (int col = 1; col <= row; col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}
	}

	private static void problem5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("직각 역삼각형을 출력할 줄 수: ");
		int num = sc.nextInt();

		for (int row = 1; row <= num; row++) {
			for (int col = num - row + 1; col > 0; col--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}