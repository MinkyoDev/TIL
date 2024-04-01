package com.shinhan.week1.day04;

import java.util.Arrays;

public class Review {

	public static void main(String[] args) {
		method3();
	}

	private static void method3() {
		int[][] arr = new int[3][4];
		int[][] arr2 = new int[3][];
		int[] arr3[] = new int[3][];
		int arr4[][] = new int[3][];

		for (int i = 0; i < arr4.length; i++) {
//			System.out.println(arr4[i]);
			arr4[i] = new int[i + 2];

			for (int j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void method2() {
		// 배열 생성 + 선언
		int[] arr = new int[3];

		// 배열 선언 + 생성 + 초기화
		int[] arr2 = new int[] { 1, 100, 1000 };
		int[] arr3 = { 1, 100, 1000 };

		// 배열 선언
		int[] arr4;
		// 배열 생성 + 초기화
		arr4 = new int[] { 1, 100, 1000 };

		for (int index = 0; index < arr4.length; index++) {

		}
	}

	private static void method1() {
		// 배열 : 같은 타입의 여러개의 값을 저장하기위한 자료구조
		// heap 영역에 연속공간을 만든다.
		// 개수를 알아야 생성가능

		// 1. 배열 선언
		int[] arr = null;

		// 2. 배열 생성
		arr = new int[3]; // 자동으로 초기화된다. 정수 -> 0

		// 3. 배열 사용
		arr[0] = 100;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);

	}
}
