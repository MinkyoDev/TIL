package com.shinhan.week1.day03;

import java.util.Arrays;

// >java ArrayTest 100 200 <= 변수 메인으로 들어감
// JVM이 class를 load(byte code가 method 영역으로 들어간다.)
// 검증
// main 시작

public class C5_2_ArrayTest {
	// 명령행 매개변수(argument)
	// 2개 입력받아서 5칙연산 수행하기
	public static void main(String[] args) {
		if (args.length == 2) {
			int su1 = Integer.parseInt(args[0]);
			int su2 = Integer.parseInt(args[1]);
			
			System.out.println(su1 + su2);
			System.out.println(su1 - su2);
			System.out.println(su1 * su2);
			System.out.println(su1 / su2);
			System.out.println(su1 % su2);
		}
		try {
			int su1 = Integer.parseInt(args[0]);
			int su2 = Integer.parseInt(args[1]);
			
			System.out.println(su1 + su2);
			System.out.println(su1 - su2);
			System.out.println(su1 * su2);
			System.out.println(su1 / su2);
			System.out.println(su1 % su2);
		}catch (ArrayIndexOutOfBoundsException aa) {
			aa.printStackTrace();
		}
		call11();
	}

	private static void call11() {
		int[] arr = new int[] { 10, 20, 30 };
		String[] arr2 = { "자바", "DB", "WEB" };

		System.out.println("=====일반 for=====");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + "번째=>" + arr[i]);
		}

		System.out.println("=====향상 for, 확장 for=====");
		for (int data : arr) {
			System.out.println(data);
		}
		for (String data : arr2) {
			System.out.println(data);
		}
	}

	private static void call10() {
		int[] arr = new int[] { 10, 20, 30 };
		int[] arr2 = arr; // 주소의 복사

		arr[0] = 99;

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2)); // arr2의 값도 변경됨

		// arraycopy를 이용하여 복사. (원본, 시작, 어디로 복사할지, 어디서부터, 어디까지)
		int[] arr3 = new int[arr.length];
		System.arraycopy(arr, 0, arr3, 0, arr.length);

		arr[0] = 88;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr3));

		arr[0] = 88;

	}

	private static void call9() {
		String[][] arr = new String[3][];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new String[] { "자바" + i, "DB" + i };
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

	private static void call8() {
		// 배열 선언 + 생성 + 초기화
		String[] arr = new String[] { "자바", "DB", "WEB", "Framework" };
		String[] arr2 = new String[4]; // null로 초기화

		arr2[0] = "자바";
		arr2[1] = "DB";
		arr2[2] = "WEB";
		arr2[3] = "Framework";
//		arr2[5] = "java";

		arr[0] += "";
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr[i] + "-----");
			System.out.print(arr2[i] + "-----");
			System.out.print(arr[i] == arr2[i] ? "주소같다" : "주소다르다");
			System.out.print(arr[i].equals(arr2[i]) ? "값이같다" : "값이다르다");
			System.out.println();
		}
	}

	private static void call7() {
		int[][] scores = new int[][] { { 10, 20, 30, 40 }, { 1, 2, 3 } };
		int total = 0;

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				total += scores[i][j];
				System.out.printf("[%d] [%d] => %d\t", i, j, scores[i][j]);
			}
			System.out.println();
		}
		System.out.println(total);
	}

	private static void call6() {
		char[][] arr = { { 'A', 'B', 'C' }, { '가', '나' }, { 'a', 'b', 'c', 'd' } };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void call5() {
		// 2차원 배열

		// 1. 배열 선언
		int[][] arr;
		int[] arr2[];
		int arr3[][];

		// 선언 + 생성 + 초기화
		int[][] arr4 = new int[][] { { 99, 88 }, { 88, 66, 55, 44 } };

		// 2. 배열 생성
		arr = new int[3][4];
		arr2 = new int[3][];
		// 배열 생성 + 초기화
		arr3 = new int[][] { { 10, 20, 30 }, { 40, 50 }, { 60, 70, 80 }, { 90 } };

		// 3. 배열 사용
		System.out.println(arr.length);
		System.out.println(arr[0].length);

		System.out.println(arr4[0][1]);
		System.out.println(arr3[2][2]);
	}

	private static void call4() {
		// 1.배열 선언
		// 2.배열 생성 + 3.초기화

		int[] arr;
//		arr = {20,40,60};  // 자동 생성이 안됨
		arr = new int[] { 20, 40, 60 }; // 자동 생성이 안됨
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call3() {
		// 1.배열 선언 + 2.배열 생성 + 3.초기화
//		int[] arr = new int[] { 10, 20, 30, 40, 50 };
		int[] arr = { 10, 20, 30, 40, 50 };
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call2() {
		// 1.배열 선언 + 2.배열 생성
		int[] arr = new int[10];
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call1() {
		// 변수 : 하나의 값을 저장하기 위한 기억장소 이름
		// 같은 타입의 값을 여러개 저장하고자 한다. (하나의 이름으로 연속공간을 index로 참조한다.)
		// index는 반드시 0부터 시작

		// 1. 배열 선언
		int[] arr1; // 둘다 가능하지만 위의 방식이 더 선호됨
		double arr2[];
		boolean[] arr3;
		char arr4[];
		String[] arr5;

		// 2. 배열 생성 - 반드시 개수를 알아야 한다. 자동으로 초기화된다.
		// 정수 -> 0, 실수 -> 0.0, boolean -> false, char -> ' ', 참조형 -> null
		arr1 = new int[10];
		arr2 = new double[10];
		arr3 = new boolean[10];
		arr4 = new char[10];
		arr5 = new String[10];

		// 3. 배열 사용
		System.out.println(arr1[0]);
		System.out.println(arr2[0]);
		System.out.println(arr3[0]);
		System.out.println(arr4[0]);
		System.out.println(arr5[0]);
	}
}
