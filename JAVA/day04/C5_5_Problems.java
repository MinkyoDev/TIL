package com.shinhan.day04;

import java.util.Arrays;
import java.util.Scanner;

public class C5_5_Problems {

	public static void main(String[] args) {
		method6();
	}

	private static void method6() {
		int count = 0;
		int[] scores = null;
		boolean isStop = false;
		Scanner sc = new Scanner(System.in);

		while (!isStop) {
			menuPrint();
			System.out.print("선택 >");
			int job = sc.nextInt();

			switch (job) {
			case 1 -> {
				System.out.print("학생수 >");
				count = sc.nextInt();
				scores = new int[count];
			}
			case 2 -> {
				if (scores == null) {
					System.out.println("학생수를 입력해주세요.");
					break; // switch 빠지기
				}
				for (int i = 0; i < count; i++) {
					System.out.printf("Scores[%d] >", i);
					scores[i] = sc.nextInt();
				}
			}
			case 3 -> {
				int i = 0;
				for (int score : scores) {
					System.out.printf("Scores[%d] : %d\n", i++, score);
//					i++;
				}
			}
			case 4 -> {
				int max = Integer.MIN_VALUE;
				int total = 0;
				for (int score : scores) {
					if (score > max) {
						max = score;
						total += score;
					}
				}
				System.out.println("죄고 점수 : " + max);
				System.out.println("평균 점수 : " + (double) total / count);
			}
			case 5 -> {
				isStop = true;
			}
			}
		}
		System.out.println("=========end=========");

	}

	private static void menuPrint() {
		System.out.println("---------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		System.out.println("---------------------------------------------");
	}

	private static void method5() {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 52, 14, 63, 82 } };
		int total = 0, count = 0;

		for (int[] datas : array) {
			for (int data : datas) {
				total += data;
				count++;
			}
		}
		System.out.println(total);
		System.out.println(count);
		System.out.println((double) total / count);
	}

	private static void method4() {
		int[] array = { 1, 5, 3, 8, 2 };
		int max = Integer.MIN_VALUE;

		for (int data : array) {
			if (data > max)
				max = data;
		}
	}

	private static void method3() {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 52, 14, 63, 82 } };

		System.out.println(array.length);
		System.out.println(array[2].length);

		System.out.println("======일반 for======");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======확장 for======");
		for (int[] i : array) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

	private static void method2() {
		Integer[] arr = new Integer[3]; // 기본형이 아닌 배열들은 모두 기본값이 null
		boolean[] arr2 = new boolean[3]; // 기본값은 false

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}

	private static void method1() {
		int a = 0;
		Integer b = 0;
		Integer c = null;
		System.out.println(a);
		System.out.println(b);

		// String은 고정문자열
		String s = "자바";
		s += "프로그래밍"; // StringBuffer.append -> String
	}
}
