package com.shinhan.day01;

import java.util.Scanner;

public class 표준입력 {

	public static void main(String[] args) {
//		f1();
		f4();
	}

	private static void f4() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("계속 하시겠습니까?");
			String work = sc.nextLine();

			if (work.equals("q")) {
				break;
			}

			System.out.print("입력 : ");
			int a = Integer.parseInt(sc.nextLine());

			System.out.print("입력 : ");
			int b = Integer.parseInt(sc.nextLine());

			System.out.printf("결과 : %d\n", a + b);
		}
		System.out.println("---end---");

		sc.close();

	}

	private static void f3() {
		// next와 nextLine을 같이 쓰는것은 좋지 않음.
		// nextLine만 이용하도록 코드 수정
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요 >>");
		String name = sc.nextLine();

		System.out.print("나이를 입력하세요 >>");
		int age = Integer.parseInt(sc.nextLine());

		System.out.print("자기소개 >>");
		String intro = sc.nextLine();

		System.out.printf("당신의 이름은 %s \n", name);
		System.out.printf("당신의 나이는 %s \n", age);
		System.out.printf("자기소개 : %s \n", intro);

		sc.close();

	}

	private static void f2() {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름과 나이를 입력 >>");
		String name = sc.next();
		int age = sc.nextInt();

		sc.nextLine();
		System.out.print("자기소개 >>");
		String intro = sc.nextLine();

		System.out.printf("당신의 이름은 %s \n", name);
		System.out.printf("당신의 나이는 %s \n", age);
		System.out.printf("자기소개 : %s \n", intro);

		sc.close();

	}

	private static void f1() {
		// 표준입력(키보드) : System.in
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요 >>");
		String name = sc.next(); // 1단어

		System.out.print("나이를 입력하세요 >>");
		int age = sc.nextInt();

		sc.nextLine(); // nextLine을 쓸떄 한번 버려줘야함. nextInt할때 enter가 같이 인식됨
		System.out.print("자리소개 >>");
		String intro = sc.nextLine(); // 1라인

		System.out.printf("당신의 이름은 %s \n", name);
		System.out.printf("당신의 나이는 %s \n", age);
		System.out.printf("자기소개 : %s \n", intro);

		sc.close();

	}

}
