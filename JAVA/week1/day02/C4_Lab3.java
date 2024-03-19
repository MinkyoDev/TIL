package com.shinhan.week1.day02;

import java.util.Scanner;

public class C4_Lab3 {

	public static void main(String[] args) {
		printSeason();
	}

	private static void printSeason() {
		Scanner sc = new Scanner(System.in);
		String message;

		System.out.print("태어난 달이 언제인가요? : ");
		int month = sc.nextInt();

		switch (month) {
		case 3, 4, 5:
			message = "봄";
			break;
		case 6, 7, 8:
			message = "여름";
			break;
		case 9, 10, 11:
			message = "가을";
			break;
		case 12, 1, 2:
			message = "겨울";
			break;
		default:
			message = "err";
		}

		if (message == "err") {
			System.out.println("1~12 사이의 숫자만 입력하셔야 합니다.");
		} else {
			System.out.printf("%s에 태어나셨네요.", message);
		}

		sc.close();
	}
}