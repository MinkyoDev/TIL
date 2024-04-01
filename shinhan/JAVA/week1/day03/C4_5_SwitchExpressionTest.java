package com.shinhan.week1.day03;

import java.util.Scanner;

// C4 확인문제
public class C4_5_SwitchExpressionTest {

	public static void main(String[] args) {
//		call();
//		call4(6);
//		call6(13);
		call8();
	}

	private static void call8() {
		Scanner sc = new Scanner(System.in);
		int amount = 0, balance = 0;
		boolean isStop = false;

		while (!isStop) {
			menu();
			String key = sc.nextLine();

			switch (key) {
			case "1":
				System.out.print("예금액 >");
				amount = Integer.parseInt(sc.nextLine());
				balance += amount;
				break;
			case "2":
				System.out.print("출금액 >");
				amount = Integer.parseInt(sc.nextLine());
				if (amount > balance) {
					System.out.println("잔고가 부족합니다.");
				} else {
					balance -= amount;
					System.out.println(amount + " - 정상출금");
				}
				break;
			case "3":
				System.out.println("잔고는 " + balance);
				break;
			case "4":
				System.out.println("=======end=======");
				isStop = true;
				break;
			default:
				break; // switch 종료
			}
		}
		System.out.println("=======프로그램 종료=======");
		sc.close();
	}

	private static void call7() {
		Scanner sc = new Scanner(System.in);
		int amount = 0, balance = 0;

		aa: while (true) {
			menu();
			String key = sc.nextLine();

			switch (key) {
			case "1":
				System.out.print("예금액 >");
				amount = Integer.parseInt(sc.nextLine());
				balance += amount;
				break;
			case "2":
				System.out.print("출금액 >");
				amount = Integer.parseInt(sc.nextLine());
				if (amount > balance) {
					System.out.println("잔고가 부족합니다.");
				} else {
					balance -= amount;
					System.out.println(amount + " - 정상출금");
				}
				break;
			case "3":
				System.out.println("잔고는 " + balance);
				break;
			case "4":
				System.out.println("=======end=======");
				break aa; // label 종료(while)

			default:
				break; // switch 종료
			}
		}
		System.out.println("=======프로그램 종료=======");
		sc.close();
	}

	private static void menu() {
		System.out.println("----------------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
		System.out.println("----------------------------");
		System.out.print("선택 >");

	}

	private static void call6(int count) {
		for (int row = 1; row <= count; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void call5() {
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("(%d, %d)", x, y);
				}
			}
		}
	}

	private static void call4(int want) {
		while (true) {
			int su1 = (int) (Math.random() * 6) + 1;
			int su2 = (int) (Math.random() * 6) + 1;

			if (su1 + su2 == want) {
				System.out.printf("(%d, %d)", su1, su2);
				break;
			}
		}
		System.out.println("ene");
	}

	private static void call3() {
		// 3. for문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 출력하는 코드를 작성에보세요.
		int total = 0;
		for (int su = 0; su <= 100; su += 3) {
			total += su;
		}
		System.out.println(total);
	}

	// switch expression
	private static void call2() {
		String grade = "B";
		int score1 = 0;
	}

	private static void call() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A":
			score1 = 100;
			break;
		case "B":
			int result = 100 - 20;
			score1 = result;
			break;
		default:
			score1 = 60;
		}
		System.out.println(score1);
	}
}
