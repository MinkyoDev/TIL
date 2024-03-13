package com.shinhan.day02;

public class C4_3_LoopingTest {

	public static void main(String[] args) {
		method4();
	}

	private static void method4() {
		// 3행 * 4열
		for (int row = 1; row <= 3; row++) {
			for (int col = 1; col <= 4; col++) {
				System.out.printf("%d행 %d열\t", row, col);
			}
			System.out.println();
		}
	}

	private static void method3() {
		int i = 1;

		// do ~ while문 : 일단 한번은 실행함
		do {
			System.out.println(i + ": while");
			i++;
		} while (i <= 10);
		System.out.println("while 후 i = " + i);
	}

	private static void method2() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i + ": while");
			i++;
		}
		System.out.println("while 후 i = " + i);
	}

	private static void method1() {
		int i;

		// 1. for문 - 조건에 맞는동안 반복
		for (i = 1; i <= 10; i++) {
			System.out.println(i + ": java 배우기");
		}
		System.out.println("for 후 i = " + i);
	}
}
